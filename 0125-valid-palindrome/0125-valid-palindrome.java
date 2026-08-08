class Solution {
    public boolean isPalindrome(String s) {

       String s1 = s.toUpperCase();
       String s2 = "";
       for(int i=0; i<=s1.length()-1; i++) {
        char ch = s1.charAt(i);
        if((ch >='A' && ch<='Z') || (ch >='0' && ch<='9')) {
            s2 = s2+ch;
        } 
       }
        int i = 0;
        int j = s2.length()-1;
        while(i < j) {
            if(s2.charAt(i) != s2.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}