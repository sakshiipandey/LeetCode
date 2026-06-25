class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
      int  ans = 0;

       for(int i = 0; i < nums.length; i++) {

       int cnt = 0;    

       for(int j = i; j < nums.length; j++) {

        if(nums[j] == target)
            cnt++;

        int len = j - i + 1;

        if(2 * cnt > len)
            ans++;
    }
  }
     return ans;
    }
}