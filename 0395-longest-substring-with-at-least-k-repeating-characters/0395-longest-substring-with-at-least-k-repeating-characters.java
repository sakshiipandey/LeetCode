class Solution {
    public int longestSubstring(String s, int k) {

        // aaabb
        // k = 3
        // count a = 3, b = 4
        // a a a b b 
        // i
        // left = a
        // right = a
        int count [] = new int[26];
        for(int i = 0; i<s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i<s.length(); i++) {
            if(count[s.charAt(i)-'a'] < k) {
                String left = s.substring(0, i);
                String right = s.substring(i+1);

                int leftAns = longestSubstring(left, k);
                int rightAns = longestSubstring(right, k);

                return Math.max(leftAns, rightAns);
            }
        }
        return s.length();
    }
}