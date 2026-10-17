class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int minSum = nums[0];
        int minEnding = nums[0];

        int maxSum = nums[0];
        int maxEnding = nums[0];

        int total = nums[0];

        for(int i = 1; i < nums.length; i++) {

            total = total + nums[i];

            maxEnding = Math.max(nums[i], maxEnding + nums[i]);
            maxSum = Math.max(maxSum, maxEnding);

            minEnding = Math.min(nums[i], minEnding + nums[i]);
            minSum = Math.min(minSum, minEnding);
        }

        if(maxSum < 0) {
            return maxSum;
        }

        int ans = total - minSum;

        return Math.max(ans, maxSum);
    }
}