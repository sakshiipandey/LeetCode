class Solution {
    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        int original = x;
        int digit = 0;

        while (x > 0) {
            int rem = x % 10;
            digit = digit * 10 + rem;
            x = x / 10;
        }

        if (digit == original) return true;

        return false;
    }
}