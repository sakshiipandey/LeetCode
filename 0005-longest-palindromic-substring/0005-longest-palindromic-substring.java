class Solution {

    int start = 0;
    int end = 0;

    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            expand(s, i, i);

            // Even length palindrome
            expand(s, i, i + 1);
        }

        return s.substring(start, end + 1);
    }

    public void expand(String s, int left, int right) {

        while (left >= 0 &&
               right < s.length() &&
               s.charAt(left) == s.charAt(right)) {

            if (right - left > end - start) {
                start = left;
                end = right;
            }

            left--;
            right++;
        }
    }
}