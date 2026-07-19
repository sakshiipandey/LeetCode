class Solution {
    public String smallestSubsequence(String s) {

        int[] freq = new int[26];

        // Count frequency of characters
        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        boolean[] visited = new boolean[26];


        for(char ch : s.toCharArray()) {

            // decrease frequency
            freq[ch - 'a']--;

            // already present, skip
            if(visited[ch - 'a']) {
                continue;
            }


            // Remove bigger characters
            while(!stack.isEmpty() &&
                  stack.peek() > ch &&
                  freq[stack.peek() - 'a'] > 0) {

                visited[stack.pop() - 'a'] = false;
            }


            stack.push(ch);
            visited[ch - 'a'] = true;
        }


        StringBuilder ans = new StringBuilder();

        while(!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}