class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;
        int n = heights.length;

        for(int i = 0; i <= n; i++) {

            int currHeight = (i == n) ? 0 : heights[i];

            while(!stack.isEmpty() &&
                  currHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int nse = i;

                int pse = stack.isEmpty() ? -1 : stack.peek();

                int width = nse - pse - 1;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        return maxArea;
    }
}