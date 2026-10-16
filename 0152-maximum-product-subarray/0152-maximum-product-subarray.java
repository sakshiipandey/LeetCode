class Solution {
    public int maxProduct(int[] nums) {
       int minEnding = nums[0];
       int maxEnding = nums[0];
       int ans = nums[0];

    for(int i = 1; i < nums.length; i++) {
        int v1 = nums[i];
        int v2 = minEnding * nums[i];
        int v3 = maxEnding * nums[i];

        int tempMax = Math.max(v1, Math.max(v2, v3));
        int tempMin = Math.min(v1, Math.min(v2, v3));

        maxEnding = tempMax;
        minEnding = tempMin;

        ans = Math.max(ans, maxEnding);
    }

    return ans;
}
}