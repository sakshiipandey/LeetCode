class Solution {
    public int scoreOfParentheses(String s) {

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                st.push(0);
            } else {
                int x = st.pop();
                int prev = st.pop();

                if (x == 0) {
                    st.push(prev + 1);
                } else {
                    st.push(prev + 2 * x);
                }
            }
        }

        return st.pop();
    }
}