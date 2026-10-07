class Solution {
    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {

            char ch = arr[i];
            char ch1 = arr[j];

            if (!(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                  ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')) {
                i++;
            }

            else if (!(ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u' ||
                       ch1 == 'A' || ch1 == 'E' || ch1 == 'I' || ch1 == 'O' || ch1 == 'U')) {
                j--;
            }

            else {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        return new String(arr);
    }
}