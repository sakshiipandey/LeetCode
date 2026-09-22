class Solution {
    public String longestNiceSubstring(String s) {

      // 1-  //YazaAay
        //   i     
        //    j
        // ans = aAa
        // c = a
        // sub = aAa
        //        k
        //nice = true

        //2 - s =
        // "Bb"
        //  i
        //   j
        //sub = Bb
        //       k
        // c = b
        // nice = true

        String ans = "";

        for(int i = 0; i < s.length(); i++) {

            for(int j = i + 1; j <= s.length(); j++) {

                String sub = s.substring(i, j);
                boolean nice = true;

                for(int k = 0; k < sub.length(); k++) {

                    char c = sub.charAt(k);

                    if(sub.indexOf(Character.toLowerCase(c)) == -1 ||
                       sub.indexOf(Character.toUpperCase(c)) == -1) {

                        nice = false;
                        break;
                    }
                }

                if(nice && sub.length() > ans.length()) {
                    ans = sub;
                }
            }
        }

        return ans;
    }
}