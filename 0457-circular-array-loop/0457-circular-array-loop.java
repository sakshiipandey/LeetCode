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

            boolean isPos = nums[i] > 0;

            int slow = i;
            int fast = i;

            while(true) {

                // slow moves one step
                int nextSlow = calcNextIdx(nums, slow);

                if(nextSlow == slow) {
                    break;
                }

                if((nums[nextSlow] > 0) != isPos) {
                    break;
                }

                slow = nextSlow;


                // fast moves first step
                int nextFast = calcNextIdx(nums, fast);

                if(nextFast == fast) {
                    break;
                }

                if((nums[nextFast] > 0) != isPos) {
                    break;
                }

                fast = nextFast;


                // fast moves second step
                nextFast = calcNextIdx(nums, fast);

                if(nextFast == fast) {
                    break;
                }

                if((nums[nextFast] > 0) != isPos) {
                    break;
                }

                fast = nextFast;


                // cycle found
                if(slow == fast) {
                    return true;
                }
            }

            // Mark this path as visited
            int curr = i;

            if(isPos) {

                while(nums[curr] > 0) {
                    int next = calcNextIdx(nums, curr);
                    nums[curr] = 0;
                    curr = next;

                    if(curr == i) {
                        break;
                    }
                }

            } else {

                while(nums[curr] < 0) {
                    int next = calcNextIdx(nums, curr);
                    nums[curr] = 0;
                    curr = next;

                    if(curr == i) {
                        break;
                    }
                }
            }
        }

        return false;
    }
}
