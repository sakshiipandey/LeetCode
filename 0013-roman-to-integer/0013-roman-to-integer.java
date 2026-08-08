
class Solution {
    public int romanToInt(String s) {

        int ans = 0;

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            int value = 0;

            // Current character ki value
            if(ch == 'I') {
                value = 1;
            }
            else if(ch == 'V') {
                value = 5;
            }
            else if(ch == 'X') {
                value = 10;
            }
            else if(ch == 'L') {
                value = 50;
            }
            else if(ch == 'C') {
                value = 100;
            }
            else if(ch == 'D') {
                value = 500;
            }
            else if(ch == 'M') {
                value = 1000;
            }

            // Agar last character hai
            if(i == s.length() - 1) {
                ans = ans + value;
            }
            else {

                // Next character
                char nextCh = s.charAt(i + 1);
                int nextValue = 0;

                // Next character ki value
                if(nextCh == 'I') {
                    nextValue = 1;
                }
                else if(nextCh == 'V') {
                    nextValue = 5;
                }
                else if(nextCh == 'X') {
                    nextValue = 10;
                }
                else if(nextCh == 'L') {
                    nextValue = 50;
                }
                else if(nextCh == 'C') {
                    nextValue = 100;
                }
                else if(nextCh == 'D') {
                    nextValue = 500;
                }
                else if(nextCh == 'M') {
                    nextValue = 1000;
                }

                // Subtract ya add
                if(value < nextValue) {
                    ans = ans - value;
                }
                else {
                    ans = ans + value;
                }
            }
        }

        return ans;
    }
}

