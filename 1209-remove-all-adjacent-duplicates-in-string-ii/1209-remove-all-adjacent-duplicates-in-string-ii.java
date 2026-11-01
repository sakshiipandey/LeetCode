class Solution {
    public String removeDuplicates(String s, int k) {

        Stack<int[]> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (!st.isEmpty() && st.peek()[0] == ch) {

                st.peek()[1]++;

                if (st.peek()[1] == k) {
                    st.pop();
                }

            } else {

                st.push(new int[]{ch, 1});

            }
        }

        StringBuilder ans = new StringBuilder();

        for (int[] pair : st) {

            for (int i = 0; i < pair[1]; i++) {
                ans.append((char) pair[0]);
            }
        }

        return ans.toString();
    }
}