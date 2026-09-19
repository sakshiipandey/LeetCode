class Solution {

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int maxT = k * threshold;
        int count = 0;

        for(int i = 0; i <= arr.length - k; i++) {

            int sum = 0;

            for(int j = i; j < i + k; j++) {
                sum = sum + arr[j];
            }

            if(sum >= maxT) {
                count = count + 1;
            }
        }

        return count;
    }
}