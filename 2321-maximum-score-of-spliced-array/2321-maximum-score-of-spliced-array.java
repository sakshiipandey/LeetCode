class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
        }

        int maxEnd = 0, minEnd = 0;
        int maxSum = 0, minSum = 0;

        for (int i = 0; i < nums1.length; i++) {
            int diff = nums2[i] - nums1[i];

            maxEnd = Math.max(0, maxEnd + diff);
            maxSum = Math.max(maxSum, maxEnd);

            minEnd = Math.min(0, minEnd + diff);
            minSum = Math.min(minSum, minEnd);
        }

        return Math.max(sum1 + maxSum, sum2 - minSum);
    }

}
