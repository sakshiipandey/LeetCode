class Solution {

    public int calcNextIdx(int nums[], int curr) {
        int next = curr;
        int seq = nums[curr];

        if(seq > 0) {
            next = (next + seq) % nums.length;
        } 
        else {
            int mod = seq % nums.length;
            int forward = nums.length + mod;
            next = (curr + forward) % nums.length;
        }

        return next;
    }

    public boolean circularArrayLoop(int[] nums) {

        for(int i = 0; i < nums.length; i = i + 1) {

            if(nums[i] == 0) {
                continue;
            }

            Set<Integer> set = new HashSet<>();
            set.add(i);

            boolean isPos = nums[i] > 0;
            int curr = i;

            while(true) {

                int next = calcNextIdx(nums, curr);

                // direction change
                if((nums[curr] > 0) != isPos) {
                    break;
                }

                // one element cycle
                if(next == curr) {
                    break;
                }

                // cycle found
                if(set.contains(next)) {
                    return true;
                }

                set.add(next);
                curr = next;
            }

            // mark visited elements
            curr = i;

            if(isPos) {

                while(nums[curr] > 0) {
                    int next = calcNextIdx(nums, curr);
                    nums[curr] = 0;
                    curr = next;
                }

            } 
            else {

                while(nums[curr] < 0) {
                    int next = calcNextIdx(nums, curr);
                    nums[curr] = 0;
                    curr = next;
                }
            }
        }

        return false;
    }
}
