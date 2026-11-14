class Solution {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < operations.length; i++) {

            if(operations[i].equals("+")) {

                int a = stack.pop();
                int b = stack.peek();

                stack.push(a);
                stack.push(a + b);

            } 
            else if(operations[i].equals("D")) {

                stack.push(stack.peek() * 2);

            } 
            else if(operations[i].equals("C")) {

                stack.pop();

            } 
            else {

                stack.push(Integer.parseInt(operations[i]));

            }
        }

        int res = 0;

        while(!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}