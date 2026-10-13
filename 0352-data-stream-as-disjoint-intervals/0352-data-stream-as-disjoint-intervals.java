class SummaryRanges {
    TreeSet<Integer> list;

    public SummaryRanges() {
        list = new TreeSet<Integer>();
    }

    public void addNum(int value) {
        list.add(value);
    }

    public int[][] getIntervals() {
        if (list.size() == 0) {
            return new int[][] {};
        }

        Integer left = null;
        Integer right = null;

        List<int[]> res = new ArrayList<>();

        for (int val : list) {
            if (left == null && right == null) {
                left = val;
                right = val;
            }
            else if (val == right + 1) {
                right = val;
            }
            else {
                res.add(new int[] {left, right});

                left = val;
                right = val;
            }
        }

        res.add(new int[] {left, right});

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