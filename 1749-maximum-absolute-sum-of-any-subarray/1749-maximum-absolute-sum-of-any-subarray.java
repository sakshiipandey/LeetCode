class Solution {
public int maxAbsoluteSum(int[] nums) {
     int maxEnd = 0, maxSum = 0;
     int minEnd = 0, minSum = 0;

    for(int x : nums) {
        maxEnd = Math.max(x, maxEnd + x);
        maxSum = Math.max(maxSum, maxEnd);

        minEnd = Math.min(x, minEnd + x);
        minSum = Math.min(minSum, minEnd);
    }

    return Math.max(Math.abs(maxSum), Math.abs(minSum));
}

}
