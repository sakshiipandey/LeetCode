class Solution { 
    public int[][] insert(int[][] intervals, int[] newInterval) { 
 
        // intervals = [[1,3],[6,9]], newInterval = [2,5] 
        // interval = [[1, 3], [6, 9]] 
        // sort -> [[1, 3], [6, 9]] 
 
        // list =  
        //  [[1, 3], [6, 9]] 
        //             i 
        // curr =  [1, 3]=> [6, 9] 
        // intervals[i] = [2, 5] => [6, 9] 
        // curr[1] < newInterval[0] => 3 < 2 =? false
        // curr[0] <= newInterval[1] => 1 <= 5 =? true
        // newInterval[0] = 1 
        // newInterval[1] = 5 
        // list = [1, 5], [6, 9] 
 
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); 
 
        ArrayList<int[]> list = new ArrayList<>(); 
 
        boolean added = false;

        for (int i = 0; i < intervals.length; i++) { 
 
            int[] curr = intervals[i]; 
 
            // curr is completely before newInterval 
            if (curr[1] < newInterval[0]) { 
                list.add(curr); 
            } 
 
            // curr overlaps with newInterval 
            else if (curr[0] <= newInterval[1]) { 
 
                newInterval[0] = Math.min(newInterval[0], curr[0]); 
                newInterval[1] = Math.max(newInterval[1], curr[1]); 
            } 
 
            // curr is completely after newInterval 
            else { 
                list.add(newInterval); 
                added = true;
 
                // newInterval add ho chuka hai 
                // baaki intervals bhi add karne hain 
                for (int j = i; j < intervals.length; j++) { 
                    list.add(intervals[j]); 
                } 
 
                break; 
            } 
        } 
 
        // list.size = 1 
        // list.get(list.size()-1) => [1, 5]  
        // newInterval = [1, 5] 
 
        // Agar newInterval last mein hai 
        if (!added) {
            list.add(newInterval);
        }
 
        //   res = [1, 5] , [6, 9] 
 
        int[][] res = new int[list.size()][2]; 
 
        for (int i = 0; i < list.size(); i++) { 
            res[i] = list.get(i); 
        } 
 
        return res; 
    } 
}