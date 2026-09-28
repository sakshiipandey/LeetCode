class Solution {
    public int divisorSubstrings(int num, int k) {
        int count = 0 ;
        String s = String.valueOf(num);
        for(int i = 0; i<=s.length()-k; i++) {
            String sub = "";
            for(int j = i; j<i+k; j++) {
                sub = sub + s.charAt(j);            }
            int num1 = Integer.parseInt(sub);
            if(num1 != 0 && num % num1 == 0){
                count++;
            }
        }
        return count;
    }
}