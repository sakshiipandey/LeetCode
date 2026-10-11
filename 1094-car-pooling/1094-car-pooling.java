class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // line sweep algorithm
        // tree map.. point of travel -> num of passengers

        Map<Integer, Integer> map = new TreeMap<>();

        for (int[] trip : trips) {
            int pass = trip[0];
            int start = trip[1];
            int end = trip[2];

            map.put(start, map.getOrDefault(start, 0) + pass);
            map.put(end, map.getOrDefault(end, 0) - pass);
        }

        int passengers = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            passengers = passengers + entry.getValue();

            if (passengers > capacity) {
                return false;
            }
        }

        return true;
    }
}

