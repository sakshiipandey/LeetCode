class Solution {
    public int[] secondGreaterElement(int[] nums) {

        int res[] = new int[nums.length];
        Arrays.fill(res, -1);

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for(int i = 0; i < nums.length; i++) {

            int curr = nums[i];

            

            // First greater element
            Stack<Integer> temp = new Stack<>();

            while(!stack1.isEmpty() &&
                  curr > nums[stack1.peek()]) {

                temp.push(stack1.pop());
            }

            // Second greater element
            while(!stack2.isEmpty() &&
                  curr > nums[stack2.peek()]) {

                res[stack2.pop()] = curr;
            }

            while(!temp.isEmpty()) {
                stack2.push(temp.pop());
            }

            stack1.push(i);
        }

        return res;
    }
}