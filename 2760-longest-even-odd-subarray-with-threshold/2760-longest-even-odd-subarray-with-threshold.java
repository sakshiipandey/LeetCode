class Solution {

    public int longestAlternatingSubarray(int[] nums, int threshold) {

        int i = 0, ans = 0;

        for(int j = 0; j < nums.length; j++) {

            if(nums[j] > threshold) {
                i = j + 1;
                continue;
            }

            if(nums[i] % 2 != 0) {
                i = j;
            }

            if(j > i && nums[j] % 2 == nums[j-1] % 2) {
                i = j;
            }

            if(nums[i] % 2 == 0) {
                ans = Math.max(ans, j - i + 1);
            }
        }

        return ans;
    }
}