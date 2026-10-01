class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {

        int min = Integer.MAX_VALUE;

        // [3, -2, 1, 4], l = 2, r = 3
        // 3 -2 1 4
        // i 
        // j 
        // length = j - i + 1 = 1

        for(int i = 0; i < nums.size(); i++) {

            int sum = 0;

            for(int j = i; j < nums.size(); j++) {

                sum = sum + nums.get(j);

                int length = j - i + 1;

                if(length >= l && length <= r && sum > 0) {
                    min = Math.min(sum, min);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}