class Solution {
    public int minimumRecolors(String blocks, int k) {
        // sliding window
        // k = 7
        // W B W B B B W

        //  W B W B B B W
        //      i
        // k =2
        // count = 2
        // ans = 2
        
        
        int count = 0;
        int ans = k;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                count++;
            }
        }
        ans = count;

        // W B W B B B W
        //             2
        // count = 2-> 3-1 => 2+1 = 3
        // i - k => 5 - 2 = 3
        // ans = Math.min(2, 3)
        // ans = 2


        

        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                count++;
            }
            if (blocks.charAt(i - k) == 'W') {
                count--;
            }
            ans = Math.min(ans, count);
        }
        return ans;
    }
}