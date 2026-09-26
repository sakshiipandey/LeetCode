class Solution {
    public String reverseWords(String s) {

        String ans = "";
        String word = "";

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) != ' ') {
                word += s.charAt(i);
            }
            else {
                for(int j = word.length() - 1; j >= 0; j--) {
                    ans += word.charAt(j);
                }

                ans += " ";
                word = "";
            }
        }

        // Last word
        for(int j = word.length() - 1; j >= 0; j--) {
            ans += word.charAt(j);
        }

        return ans;
    }
}