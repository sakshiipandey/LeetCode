class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {

        int count = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> list = new ArrayList<>();

        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] prev = list.get(list.size() - 1);
            int[] curr = intervals[i];

            if (curr[0] < prev[1]) {

                count++;

                if (curr[1] < prev[1]) {
                    list.remove(list.size() - 1);
                    list.add(curr);
                }

            } else {

                list.add(curr);
            }
        }

        return count;
    }
}