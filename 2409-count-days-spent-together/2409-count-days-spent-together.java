class Solution {
public int countDaysTogether(String arriveAlice, String leaveAlice,
String arriveBob, String leaveBob) {
    int a1 = convert(arriveAlice);
    int a2 = convert(leaveAlice);
    int b1 = convert(arriveBob);
    int b2 = convert(leaveBob);

    int start = Math.max(a1, b1);
    int end = Math.min(a2, b2);

    return Math.max(0, end - start + 1);
}

public int convert(String date) {
    int[] days = {
        31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31
    };

    int month = Integer.parseInt(date.substring(0, 2));
    int day = Integer.parseInt(date.substring(3, 5));

    int total = day;

    for (int i = 0; i < month - 1; i++) {
        total += days[i];
    }

    return total;
}}