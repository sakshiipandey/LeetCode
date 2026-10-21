class Solution {
    public int maxScore(String s) {
        int maxScore=0;
        for(int i=1; i<s.length(); i++){
            String left=s.substring(0,i);
            String right=s.substring(i);
            int zeroes=0;
            int ones=0;
            for(int j=0; j<left.length(); j++){
                if(left.charAt(j)=='0'){
                    zeroes++;
                }
            }
            for(int j=0; j<right.length(); j++){
                if(right.charAt(j)=='1'){
                    ones++;
                }
            }
            maxScore=Math.max(maxScore, zeroes+ones);
        }
        return maxScore;
    }
}