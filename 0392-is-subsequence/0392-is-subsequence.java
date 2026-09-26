class Solution {
    public boolean isSubsequence(String s, String t) {

        int i = 0, j = 0;
        int count = 0;

        while(i < s.length() && j < t.length()) {

            if(s.charAt(i) == t.charAt(j)) {
                i++;
                count++;
            }

            j++;
        }

        if(count == s.length()) {
            return true;
        }

        return false;
    }
}