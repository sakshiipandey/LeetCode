class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        // separate negative and positive numbers
        for(int num : nums) {
            if(num < 0) {
                neg.add(num);
            } else {
                pos.add(num);
            }
        }

        // case 1: no negative number
        if(neg.size() == 0) {
            for(int i = 0; i < pos.size(); i++) {
                pos.set(i, pos.get(i) * pos.get(i));
            }

            return pos.stream()
                      .mapToInt(Integer::intValue)
                      .toArray();
        }

        // case 2: no positive number
        if(pos.size() == 0) {
            for(int i = 0; i < neg.size(); i++) {
                neg.set(i, neg.get(i) * neg.get(i));
            }

            Collections.reverse(neg);

            return neg.stream()
                      .mapToInt(Integer::intValue)
                      .toArray();
        }

        // case 3: both negative and positive exist
        int i = 0, j = 0, id = 0;

        int n1 = neg.size();
        int n2 = pos.size();

        int[] res = new int[n1 + n2];

        // square negative numbers and reverse them
        for(int k = 0; k < n1; k++) {
            neg.set(k, neg.get(k) * neg.get(k));
        }

        Collections.reverse(neg);

        // square positive numbers
        for(int k = 0; k < n2; k++) {
            pos.set(k, pos.get(k) * pos.get(k));
        }

        // merge neg and pos
        while(i < n1 && j < n2) {
            if(neg.get(i) <= pos.get(j)) {
                res[id++] = neg.get(i++);
            } else {
                res[id++] = pos.get(j++);
            }
        }

        while(i < n1) {
            res[id++] = neg.get(i++);
        }

        while(j < n2) {
            res[id++] = pos.get(j++);
        }

        return res;
    }
}