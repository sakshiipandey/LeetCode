import java.util.*;

class Solution {
    public int firstStableIndex(int[] nums, int k) {

        for (int i = 0; i < nums.length; i++) {

            ArrayList<Integer> max = new ArrayList<>();
            ArrayList<Integer> min = new ArrayList<>();

            
            for (int j = 0; j <= i; j++) {
                max.add(nums[j]);
            }

            
            for (int j = i; j < nums.length; j++) {
                min.add(nums[j]);
            }

            int maxNum = Collections.max(max);
            int minNum = Collections.min(min);

            int res = maxNum - minNum;

            if (res <= k) {
                return i;
            }
        }

        return -1;
    }
}