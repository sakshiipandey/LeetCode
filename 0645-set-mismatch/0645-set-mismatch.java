class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);

        int left= 0;
        int right = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                left = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == right) {
                right++;
            }
        }

        return new int[]{left, right};
    }
}