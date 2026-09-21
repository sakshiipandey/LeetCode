class Solution {

    public int findLHS(int[] nums) {

        Arrays.sort(nums);

        int count = 0, ans = 0, i = 0, j = 0;

        while (j < nums.length) {

            while (nums[j] - nums[i] > 1) {
                i++;
            }

            if (nums[j] - nums[i] == 1) {
                count = j - i + 1;
                ans = Math.max(ans, count);
            }

            j++;
        }

        return ans;
    }
}