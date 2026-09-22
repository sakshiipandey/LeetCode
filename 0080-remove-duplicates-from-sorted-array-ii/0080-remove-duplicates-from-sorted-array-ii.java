class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int res = 0;

        while(j < nums.length) {

            if(res < 2 || nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
                res++;
            }

            j++;
        }

        return res;
    }
}