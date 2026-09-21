class Solution {
    public int characterReplacement(String s, int k) {
        int maxC = 0, i = 0, j = 0, max = 0;
        int [] counts = new int[26];
        while(j<s.length()) {
            char c = s.charAt(j);
            counts[c - 'A'] = counts[c - 'A'] + 1;
            maxC = Math.max(maxC, counts[c - 'A']);
            while(j-i+1 - maxC > k) {
                char d = s.charAt(i);
                counts[d-'A'] = counts[d-'A'] - 1;

                i++;

                maxC = 0;

                for(int l = 0; l<26; l++) {
                    maxC = Math.max(maxC, counts[l]);
                }
            }
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}