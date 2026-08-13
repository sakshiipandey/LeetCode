class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result_sum = 0;
        int min_diff = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);

                if (diff < min_diff) {
                    min_diff = diff;
                    result_sum = sum;
                }

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }
            }
        }

        return result_sum;
    }
}