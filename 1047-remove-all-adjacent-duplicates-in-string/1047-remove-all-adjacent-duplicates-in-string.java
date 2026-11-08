class Solution {
    public String removeDuplicates(String s) {
        // abbaca
        // aaca
        // ca
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        // ca
        // ac

        StringBuilder s0 = new StringBuilder();

        while(!stack.isEmpty()) {
            s0.append(stack.pop());
        }
        s0.reverse();
        return s0.toString();
    }
}