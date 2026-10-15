class Solution {
    public void sortColors(int[] nums) {
        int minIndex = 0;

        for(int i = 0; i< nums.length; i++) {
            minIndex = i;
            for(int j = i+1; j<nums.length; j++) {
                if(nums[j] < nums[minIndex]) {
                      minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }
}