class Solution {
    public int[] arrayRankTransform(int[] arr) {

        if (arr.length == 0) {
            return arr;
        }

        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        for (int i = 0; i < temp.length; i++) {

            if (!map.containsKey(temp[i])) {
                map.put(temp[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}