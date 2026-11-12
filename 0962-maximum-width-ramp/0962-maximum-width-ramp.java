class Solution {
    public int maxWidthRamp(int[] nums) {

        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        
        for(int i = 0; i < nums.length; i++) {

            if(stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

       
        for(int j = nums.length - 1; j >= 0; j--) {

            while(!stack.isEmpty() && nums[j] >= nums[stack.peek()]) {

                ans = Math.max(ans, j - stack.pop());
            }
        }

        return ans;
    }
}