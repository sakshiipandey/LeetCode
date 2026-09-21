class Solution {
    public int findLHS(int[] nums) {

        Arrays.sort(nums);

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            int count = 1;
            boolean found = false;

            for (int j = i + 1; j < nums.length; j++) {

                if (Math.abs(nums[i] - nums[j]) == 1) {

                    count++;
                    found = true;

                } else if (nums[i] == nums[j]) {

                    count++;
                }

                if (nums[j] > nums[i] + 1) {
                    break;
                }
            }

            if (found) {
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }
}