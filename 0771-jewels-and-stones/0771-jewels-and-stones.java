class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        int i = 0;
        int j = 0;
        int count = 0;

        while (j < stones.length()) {

            i = 0;

            while (i < jewels.length()) {

                if (jewels.charAt(i) == stones.charAt(j)) {
                    count++;
                    break;
                }

                i++;
            }

            j++;
        }

        return count;
    }
}