class Solution {
    public String makeGood(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (stack.isEmpty()) {
                stack.push(ch);
            }

            else if (Character.toLowerCase(stack.peek()) == Character.toLowerCase(ch)
                    && stack.peek() != ch) {

                stack.pop();
            }

            else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }
}