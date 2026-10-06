class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int i = 0;

        List<int[]> res = new ArrayList<>();

        // 1. Jo intervals newInterval se pehle hain
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // 2. Overlapping intervals ko merge karo
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {

            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        res.add(newInterval);

        // 3. Remaining intervals
        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        // List -> 2D array
        int[][] ans = new int[res.size()][2];

        for (int j = 0; j < res.size(); j++) {
            ans[j] = res.get(j);
        }

        return ans;
    }
}