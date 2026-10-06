class Solution {
    public int countDays(int days, int[][] meetings) {

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        int meetingDays = 0;

        ArrayList<int[]> res = new ArrayList<>();

        res.add(meetings[0]);

        for (int i = 1; i < meetings.length; i++) {

            if (meetings[i][0] <= res.get(res.size() - 1)[1]) {

                res.get(res.size() - 1)[0] = Math.min(
                    res.get(res.size() - 1)[0],
                    meetings[i][0]
                );

                res.get(res.size() - 1)[1] = Math.max(
                    res.get(res.size() - 1)[1],
                    meetings[i][1]
                );
            }
            else {
                res.add(meetings[i]);
            }
        }

        for (int i = 0; i < res.size(); i++) {
            meetingDays = meetingDays 
                         + res.get(i)[1] - res.get(i)[0] + 1;
        }

        return days - meetingDays;
    }
}