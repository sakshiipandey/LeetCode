class Solution {
    public int[] canSeePersonsCount(int[] heights) {

        int[] res = new int[heights.length];
        Arrays.fill(res, 0);

        Stack<Integer> stack = new Stack<>();

        for(int i = heights.length - 1; i >= 0; i--) {

            int curr = heights[i];

            while(!stack.isEmpty() &&
                  curr > heights[stack.peek()]) {

                // check further which person can see by res[i]++    

                stack.pop();
                res[i]++;
            }

            if(!stack.isEmpty()) {
                res[i]++;
            }

            stack.push(i);
        }

        return res;
    }
}