class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);

            if(map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }

            map.put(c, j);

            max = Math.max(max, j - i + 1);
        }

        return max;
    }
}