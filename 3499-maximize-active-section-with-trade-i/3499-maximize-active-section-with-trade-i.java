class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }

        String t = "1" + s + "1";

        ArrayList<Character> type = new ArrayList<>();
        ArrayList<Integer> len = new ArrayList<>();

        int i = 0;

        while (i < t.length()) {
            char ch = t.charAt(i);
            int j = i;

            while (j < t.length() && t.charAt(j) == ch) {
                j++;
            }

            type.add(ch);
            len.add(j - i);

            i = j;
        }

        int gain = 0;

        for (int k = 1; k < type.size() - 1; k++) {

            if (type.get(k) == '1'
                    && type.get(k - 1) == '0'
                    && type.get(k + 1) == '0') {

                gain = Math.max(gain,
                        len.get(k - 1) + len.get(k + 1));
            }
        }

        return totalOnes + gain;
    }
}