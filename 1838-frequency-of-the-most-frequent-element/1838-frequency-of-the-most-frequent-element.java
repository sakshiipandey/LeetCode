class Solution {
    public int maxFrequency(int[] nums, int k) {

        // nums = [1,2,4], k = 5
        // sort -> 1, 2, 4
        //         i
                //       j 
                // max = 2 
                // sum = 3 + 4 = 7  
                // 4 * 1 - 3 = 1 > 5 
                // j - i + 1 => 2 - 0 +1 = 3
        int max = 0;
        Arrays.sort(nums);
        long sum = 0;
        int i = 0, j = 0;
        while(j<nums.length) {
            sum = sum + nums[j];
            while((long) nums[j] * (j-i+1) - sum > k) {
                sum = sum - nums[i];
                i++;
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}