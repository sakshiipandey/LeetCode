class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long max = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int dups = 0;

        // First window
        for (int i = 0; i < k; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }

            map.put(nums[i], map.get(nums[i]) + 1);

            sum = sum + nums[i];

            if (map.get(nums[i]) > 1) {
                dups++;
            }
        }

        if (dups == 0) {
            max = Math.max(max, sum);
        }

        // Sliding window
        for (int i = k; i < nums.length; i++) {

            // Remove old element
            int numToRemove = nums[i - k];

            if (map.get(numToRemove) > 1) {
                dups--;
            }

            map.put(numToRemove, map.get(numToRemove) - 1);
            sum = sum - numToRemove;

            // Add new element
            int numToAdd = nums[i];

            if (!map.containsKey(numToAdd)) {
                map.put(numToAdd, 0);
            }

            map.put(numToAdd, map.get(numToAdd) + 1);

            if (map.get(numToAdd) > 1) {
                dups++;
            }

            sum = sum + numToAdd;

            if (dups == 0) {
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}