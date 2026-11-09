class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(') {
                stack.push(i);
            } else if(c == ')') {
                if(stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()) {
            set.add(stack.pop());
        }
        StringBuilder sB = new StringBuilder();

        for(int i = 0; i< s.length(); i++) {
            if(set.contains(i)) {
                continue;
            }
            sB.append(s.charAt(i));
        }
        return sB.toString();
    }
}