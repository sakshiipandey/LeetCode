class Solution {
    public int[] decrypt(int[] code, int k) {
         int[] ans = new int [code.length];
        for(int i = 0; i<code.length; i++) {
             int sum = 0;
            if(k>0) {
                for(int j = 1; j<=k; j++) {
                    sum = sum + code[(i + j) % code.length];
                }
                ans[i] = sum;
            }
            else if(k<0){
                for(int j = 1; j<= -k; j++) {
                    sum = sum+code[(i - j + code.length) % code.length];
                }
                ans[i] = sum;
            }
            else {
                ans[i] = 0;
            }
        }
        return ans;
    }
}