class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = 1;
        int count = 0;
        while(j<nums.length) {

            if(i == j) {
               
                j++;
                continue;
            }
            int diff = Math.abs(nums[i] - nums[j]);
            if(diff == k) {
                count++;
                i++;
                j++;
                while(i < nums.length && nums[i] == nums[i-1]) {

                    i++;
                } while(j< nums.length && nums[j] == nums[j-1]) {
                    j++;
                }
            } else if (diff < k) {
                j++;
            } else {
                i++;
            }
        }
        return count;
    }
}