class Solution {
    public void reverseString(char[] s) {

        int n = s.length;

        ArrayList<Character> arr = new ArrayList<>(n);

        for(int i = n - 1; i >= 0; i--) {
            arr.add(s[i]);
        }

        for(int i = 0; i < n; i++) {
            s[i] = arr.get(i);
        }
    }
}