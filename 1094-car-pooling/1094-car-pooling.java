class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int [] buckets = new int[1001];
        for(int [] trip : trips) {
            int pass = trip[0],
            start = trip[1],
            end = trip[2];


             buckets[start] = buckets[start] + pass;
             buckets[end] = buckets[end] - pass;
        }
        int passengers = 0;

        for(int bucket : buckets) {
            passengers = passengers + bucket;

            if(passengers > capacity) {
                return false;
            }
        }
        return true;
    }
}