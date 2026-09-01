class Solution {

    public int firstUniqChar(String s) {

        int i = 0;

        while (i < s.length()) {

            int j = 0;

            while (j < s.length()) {

                if (i != j && s.charAt(i) == s.charAt(j)) {
                    break;
                }

                j++;
            }

            if (j == s.length()) {
                return i;
            }

            i++;
        }

        return -1;
    }
}