class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        int prefix = 1;

        // Left side product
        for(int i = 0; i < n; i++) {
            arr[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;

        // Right side product
        for(int i = n - 1; i >= 0; i--) {
            arr[i] *= suffix;
            suffix *= nums[i];
        }

        return arr;
    }
}