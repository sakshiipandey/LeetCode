class Solution {
    public boolean find132pattern(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        int third = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            // Check if nums[i] can be the 1
            if (nums[i] < third) {
                return true;
            }

            // Find a possible 3
            while (!stack.isEmpty() && nums[i] > stack.peek()) {

                third = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
}