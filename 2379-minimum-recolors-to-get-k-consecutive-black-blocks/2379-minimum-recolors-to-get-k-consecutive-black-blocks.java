class Solution {
    public int minimumRecolors(String blocks, int k) {
      int ans = k;
      for(int i = 0; i<= blocks.length()-k; i++) {
        int count = 0;
        for(int j = i; j < i+k; j++) {
            if(blocks.charAt(j) == 'W') {
                count++;
            }
        }
        ans = Math.min(ans, count);
      }  
      return ans;
    }
}