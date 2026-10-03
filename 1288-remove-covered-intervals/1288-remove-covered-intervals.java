class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        // intervals = [[1,4],[3,6],[2,8]]
        // [[1, 4], [2, 8], [3, 6]]
        //            i
        // list = [[1, 4]]
        // prev = [1, 4]
        // curr = [2, 8]
        // curr[0] < prev[1] => 2 < 4
        // cur[1] < prev [1] => 8<4
        // list => [[2,8]]

       

        int count = 0;
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        // intervals = [[1,2],[1,3],[1,4]]
        // a[0] = b[0] => 1 = 1
        // b[1], a[1] => 3 > 2
        // [1, 3], [1, 2]

        // a[0] = b[0] => 1 = 1
        // b[1] => a[1] => 4 > 3
        // [1, 4] [ 1, 3]

        // final => [[1, 4], [1, 3], [1, 2]]



        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

         // intervals = [[1,2],[1,3],[1,4]]
        // sort -> [[1, 4], [1, 3], [1, 2]]
        //                            i
        // list = [[1, 4], [1, 3]]

        // prev = [1, 4] => [1, 3]
        // curr [1, 4] => [1, 3]=> [1, 2]
        // curr [0] >= prev[0] && curr[1] <= prev[1] => 1 >= 1 && 2 <= 3 => true
        // count = 1+1 
        // n = 3
        // n - count => 3 - 2 = 1
        for (int i = 1; i < n; i++) {

            int[] prev = list.get(list.size() - 1);
            int[] curr = intervals[i];

            if (curr[0] >= prev[0] && curr[1] <= prev[1]) {
                count++;
            } else {
                list.add(curr);
            }
        }

        return n - count;
    }
}