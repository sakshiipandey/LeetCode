class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        // arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
        // sum = 2 + 2  + 2 = 6
        // count  = 3
        // maxT = 3 * 4 = 12
        // 2,2,2,2,5,5,5,8
        //      i
        // 0 1 2 3 4 5 6 7
        // 2,2,2,2,5,5,5,8
        //               i
        // sum = 15 + 8 = 23
        // sum  = 23 - 5 = 18

        int sum = 0;
        int maxT = k * threshold;
        for(int i = 0; i<k; i++) {
            sum = sum + arr[i];
        }
        int count = 0;
        if(sum >= maxT) {
            count = count + 1;
        }
        for(int i = k; i< arr.length; i++) {
            sum = sum + arr[i];
            sum = sum - arr[i-k];
            if(sum >= maxT) {
                count++;
            }
        }
        return count;
    }
}