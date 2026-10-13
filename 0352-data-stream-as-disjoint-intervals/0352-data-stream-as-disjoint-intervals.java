class SummaryRanges {
    List<Integer> list;

    public SummaryRanges() {
        list = new ArrayList<Integer>();
    }

    public void addNum(int value) {
        if (list.contains(value)) {
            return;
        }

        list.add(value);
    }

    public int[][] getIntervals() {
        if (list.size() == 0) {
            return new int[][] {};
        }

        Collections.sort(list);

        // initially
        Integer left = null;
        Integer right = null;

        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (left == null && right == null) {
                left = list.get(i);
                right = list.get(i);
            } 
            else if (list.get(i) == right + 1) {
                right = list.get(i);
            } 
            else {
                res.add(new int[] {left, right});
                left = list.get(i);
                right = list.get(i);
            }
        }

        res.add(new int[] {left, right});

        // list -> 2D array
        int[][] ans = new int[res.size()][2];

        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}



/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */