class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;
        while(j<n) {
            sum = sum + nums[j];
            while(sum >= target) {
                min = Math.min(min, j - i + 1);
                sum = sum - nums[i];
                i++;
            }
            j++;
        }
        if(min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
    }
}