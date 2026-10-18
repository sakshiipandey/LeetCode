class Solution {
public int getMaxLen(int[] nums) {
    int maxending = 0;
    int minending = 0;
    int res = 0;

    for (int i = 0; i < nums.length; i++) {

        if (nums[i] == 0) {
            maxending = 0;
            minending = 0;
        }
        else if (nums[i] > 0) {
            maxending++;
            minending = (minending == 0) ? 0 : minending + 1;
        }
        else {
            int temp = maxending;

            maxending = (minending == 0) ? 0 : minending + 1;
            minending = temp + 1;
        }

        res = Math.max(res, maxending);
    }

    return res;
}

}