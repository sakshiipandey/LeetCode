class Solution {
    public String[] findRelativeRanks(int[] score) {

        int n = score.length;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        Arrays.sort(arr, (a, b) -> score[b] - score[a]);

        String[] ans = new String[n];

        for (int i = 0; i < n; i++) {

            if (i == 0) {
                ans[arr[i]] = "Gold Medal";
            } 
            else if (i == 1) {
                ans[arr[i]] = "Silver Medal";
            } 
            else if (i == 2) {
                ans[arr[i]] = "Bronze Medal";
            } 
            else {
                ans[arr[i]] = String.valueOf(i + 1);
            }
        }

        return ans;
    }
}