import java.util.Arrays;

class Solution {
public boolean checkInclusion(String s1, String s2) {
    char[] char1 = s1.toCharArray();
    Arrays.sort(char1);

    int i = 0, j = s1.length();

    while(j <= s2.length()) {
        char[] char2 = s2.substring(i, j).toCharArray();
        Arrays.sort(char2);

        if(Arrays.equals(char1, char2)) {
            return true;
        }

        i++;
        j++;
    }

    return false;
}
}
