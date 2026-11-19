class Solution {
    public int sumSubarrayMins(int[] arr) {

        // [11,81,94,43,3]
        // subarray => [94], [11, 81, 94], [43, 3], [81], [11, 81, 94, 43, 3],  [94,  43], [3], [81, 94, 43], [11], [43], [11, 81], [94, 43, 3], [81, 94], [11, 81, 94, 43], [81, 94, 43, 3]   

        // min => 94+11+3+81+3+43+3+43+11+43+11+3+81+11+3  = 444

        int mod = 1000000007;

        int [] left = new int[arr.length];
        int [] right = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i+1 : i - stack.peek();
            stack.push(i);
         }
         stack.clear();

         for(int i = arr.length - 1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? arr.length- i : stack.peek() - i;
            stack.push(i);
         }
            long sum = 0;

        for(int i = 0; i < arr.length; i++) {

            long contribution = (long) arr[i] * left[i] * right[i];

            sum = (sum + contribution) % mod;
        }

        return (int) sum;
    }
}