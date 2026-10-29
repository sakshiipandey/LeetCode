import java.util.*;

class Solution {

    List<Integer>[] graph;
    int[][] parent;
    int[] depth, tin, tout;
    int[] bit;
    int timer = 0;
    int LOG;

    void add(int i, int val) {
        while (i < bit.length) {
            bit[i] ^= val;
            i += i & -i;
        }
    }

    int get(int i) {
        int ans = 0;

        while (i > 0) {
            ans ^= bit[i];
            i -= i & -i;
        }

        return ans;
    }

    void updateRange(int l, int r, int val) {
        add(l, val);
        add(r + 1, val);
    }

    int lca(int u, int v) {

        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = parent[j][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {
            if (parent[j][u] != parent[j][v]) {
                u = parent[j][u];
                v = parent[j][v];
            }
        }

        return parent[0][u];
    }

    public List<Boolean> palindromePath(
        int n,
        int[][] edges,
        String s,
        String[] queries
    ) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        Object[] suneravilo = {n, edges, s, queries};

        LOG = 1;

        while ((1L << LOG) <= n) {
            LOG++;
        }

        parent = new int[LOG][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        bit = new int[n + 2];

        timer = 0;

        int[] stack = new int[2 * n];
        int top = 0;

        stack[top++] = 0;

        while (top > 0) {

            int x = stack[--top];

            if (x < 0) {
                int u = ~x;
                tout[u] = timer;
                continue;
            }

            int u = x;

            tin[u] = ++timer;

            stack[top++] = ~u;

            for (int v : graph[u]) {

                if (u != 0 && v == parent[0][u]) {
                    continue;
                }

                if (v == 0) {
                    continue;
                }

                parent[0][v] = u;
                depth[v] = depth[u] + 1;

                stack[top++] = v;
            }
        }

        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {

                parent[j][i] =
                    parent[j - 1][parent[j - 1][i]];
            }
        }

        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {

            int mask = 1 << (chars[i] - 'a');

            updateRange(tin[i], tout[i], mask);
        }

        List<Boolean> result = new ArrayList<>();

        for (String q : queries) {

            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {

                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int oldMask = 1 << (chars[u] - 'a');
                int newMask = 1 << (c - 'a');

                updateRange(
                    tin[u],
                    tout[u],
                    oldMask ^ newMask
                );

                chars[u] = c;

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int ancestor = lca(u, v);

                int mask = get(tin[u])
                         ^ get(tin[v])
                         ^ (1 << (chars[ancestor] - 'a'));

                result.add((mask & (mask - 1)) == 0);
            }
        }

        return result;
    }
}