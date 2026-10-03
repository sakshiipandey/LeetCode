class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        ArrayList<int[]> res = new ArrayList<>();

        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {

            int e1 = firstList[i][1];
            int e2 = secondList[j][1];

            int s1 = firstList[i][0];
            int s2 = secondList[j][0];   // yaha [1] nahi [0]

            if (e1 >= s2 && e2 >= s1) {

                res.add(new int[] {
                    Math.max(s1, s2),
                    Math.min(e1, e2)
                });
            }

            if (e1 < e2) {
                i++;
            } else {
                j++;
            }
        }

        int[][] ans = new int[res.size()][2];

        for (int k = 0; k < res.size(); k++) {
            ans[k] = res.get(k);
        }

        return ans;
    }
}