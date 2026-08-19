class Solution {
    public int findDuplicate(int[] nums) {

        Arrays.sort(nums);

        int i = 0;
        int j = i + 1;

        while (j < nums.length) {

            if (nums[i] == nums[j]) {
                return nums[i];
            }

            i++;
            j++;
        }

        return -1;
    }
}