class Solution {

    public int reverseDegree(String s) {

        int ans = 0;

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            int reversedIdx = 'z' - c + 1;

            int prod = reversedIdx * (i + 1);

            ans = ans + prod;
        }

        return ans;
    }
}