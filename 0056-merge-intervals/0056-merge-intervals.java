class Solution {

    public boolean isoverlapped(int[] int1, int[] int2) {
        return int1[1] >= int2[0] && int2[1] >= int1[0];
    }

    public int[][] merge(int[][] intervals) {

        List<int[]> list = new ArrayList<>();

        for (int[] interval : intervals) {
            list.add(interval);
        }

        boolean ismergedhappend = true;

        while (ismergedhappend) {

            ismergedhappend = false;

            for (int i = 0; i < list.size(); i++) {

                int j = i + 1;

                while (j < list.size()) {

                    int[] int1 = list.get(i);
                    int[] int2 = list.get(j);

                    if (isoverlapped(int1, int2)) {

                        int1[0] = Math.min(int1[0], int2[0]);
                        int1[1] = Math.max(int1[1], int2[1]);

                        list.remove(j);

                        ismergedhappend = true;

                    } else {
                        j++;
                    }
                }
            }
        }

        int[][] res = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}