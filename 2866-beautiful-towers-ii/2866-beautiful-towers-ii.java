class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {

        int n = maxHeights.size();

        long[] left = new long[n];
        long[] right = new long[n];

        Stack<Integer> stack = new Stack<>();

        // Calculate Left Contribution

        for(int i = 0; i < n; i++) {

            while(!stack.isEmpty() &&
                  maxHeights.get(stack.peek()) >= maxHeights.get(i)) {

                stack.pop();
            }

            if(stack.isEmpty()) {

                left[i] = (long)(i + 1) * maxHeights.get(i);

            } else {

                int j = stack.peek();

                left[i] = left[j] +
                          (long)(i - j) * maxHeights.get(i);
            }

            stack.push(i);
        }

        stack.clear();

        // Calculate Right Contribution

        for(int i = n - 1; i >= 0; i--) {

            while(!stack.isEmpty() &&
                  maxHeights.get(stack.peek()) >= maxHeights.get(i)) {

                stack.pop();
            }

            if(stack.isEmpty()) {

                right[i] = (long)(n - i) * maxHeights.get(i);

            } else {

                int j = stack.peek();

                right[i] = right[j] +
                           (long)(j - i) * maxHeights.get(i);
            }

            stack.push(i);
        }

        // Calculate Maximum Sum

        long ans = 0;

        for(int i = 0; i < n; i++) {

            ans = Math.max(ans,
                    left[i] + right[i] - maxHeights.get(i));
        }

        return ans;
    }
}