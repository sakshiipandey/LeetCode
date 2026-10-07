class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        int count = 0;

        for(int i = 0; i < intervals.length; i++) {

            int c = intervals[i][0];
            int d = intervals[i][1];

            boolean isCovered = false;

            for(int j = 0; j < intervals.length; j++) {

                if(i != j) {

                    int a = intervals[j][0];
                    int b = intervals[j][1];

                    if(a <= c && b >= d) {
                        isCovered = true;
                        break;
                    }
                }
            }

            if(!isCovered) {
                count++;
            }
        }

        return count;
    }
}