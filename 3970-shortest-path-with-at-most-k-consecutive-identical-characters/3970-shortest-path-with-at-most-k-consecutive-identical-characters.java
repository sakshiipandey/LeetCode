class Solution {
    static class State {
        int node, dist, streak;
        char last;

        State(int node, int dist, char last, int streak) {
            this.node = node;
            this.dist = dist;
            this.last = last;
            this.streak = streak;
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i=0; i< n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int [] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist)); 

        HashMap<String, Integer > best = new HashMap<>();
         pq.offer(new State(0, 0, labels.charAt(0), 1));

        while(!pq.isEmpty()) {
            State cur = pq.poll();

            String key = cur.node + "#" + cur.last + "#" + cur.streak;

            if(best.containsKey(key) && best.get(key) < cur.dist) {
                continue;
            }
            if(cur.node == n-1) {
                return cur.dist;
            }
            for(int[] nxt : graph[cur.node]) {
                int v = nxt[0];
                int w = nxt[1];

                char c = labels.charAt(v);

                int ns;

                if(c == cur.last) {
                    ns = cur.streak +1;
                } else {
                    ns = 1;
                }
                if(ns > k) continue;

                int nd = cur.dist + w;

                String nkey = v + "#" + c + "#" + ns;
                if(!best.containsKey(nkey) || nd < best.get(nkey)) {
                    best.put(nkey, nd);
                    pq.offer(new State(v, nd, c, ns));
                }
            }
        }
        return -1;
    }
}