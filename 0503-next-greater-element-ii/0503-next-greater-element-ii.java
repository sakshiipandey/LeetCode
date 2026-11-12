class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] res = new int [nums.length];
        Arrays.fill(res, -1);
        // nge first pass
        Stack<Integer> stack = new Stack<>();

        // indice's stack

        for(int i = 0; i<nums.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
             int curr = nums[i];

             while(!stack.isEmpty() && curr > nums[stack.peek()]) {
                res[stack.pop()] = curr;
             }
             stack.push(i);
        }
        // one pass completed

         for(int i = 0; i<nums.length; i++) {
            if(stack.isEmpty()) {
                stack.push(i);
                continue;
            }
             int curr = nums[i];

             while(!stack.isEmpty() && curr > nums[stack.peek()]) {
                res[stack.pop()] = curr;
             }
             stack.push(i);
        }
        return res;
    }
}