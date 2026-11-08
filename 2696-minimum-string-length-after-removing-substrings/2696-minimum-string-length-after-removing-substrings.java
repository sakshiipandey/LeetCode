import java.util.*;

class Solution {
    public int minLength(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (!stack.isEmpty() &&
                ((c == 'B' && stack.peek() == 'A') ||
                 (c == 'D' && stack.peek() == 'C'))) {

                stack.pop();

            } else {
                stack.push(c);
            }
        }

        return stack.size();
    }
}