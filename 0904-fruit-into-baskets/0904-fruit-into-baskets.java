class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, maxLen = 0;

        Map<Integer, Integer> basket = new HashMap<>();

        for (int right = 0; right < n; right++) {

            int currentCount = basket.getOrDefault(fruits[right], 0);
            basket.put(fruits[right], currentCount + 1);

            // if basket has more than 2 types of fruits
            // start removing fruits from left

            while (basket.size() > 2) {

                int fruitsCount = basket.get(fruits[left]);

                if (fruitsCount == 1) {
                    basket.remove(fruits[left]);
                } else {
                    basket.put(fruits[left], fruitsCount - 1);
                }

                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}