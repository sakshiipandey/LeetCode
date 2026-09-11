class Solution {

    public int calcNextidx(int nums[], int curr) {
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

            Set<Integer> set = new HashSet<>();
            set.add(i);

            boolean isPos = nums[i] > 0;
            int curr = i;

            while(true) {

                int next = calcNextidx(nums, curr);

                if(next == curr) {
                    break;
                }

                if((nums[next] > 0) != isPos) {
                    break;
                }

                if(set.contains(next)) {
                    return true;
                }

                set.add(next);
                curr = next;
            }
        }

        return false;
    }
}

