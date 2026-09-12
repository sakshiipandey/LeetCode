class Solution {
    public void reorderList(ListNode head) {
        LinkedList<Integer> record = new LinkedList<>();

        ListNode last = head;

        while (last.next != null) {
            last = last.next;
        }

        ListNode left = head;
        ListNode right = last;

        while (left != right && left.next != right) {
            record.add(left.val);
            record.add(right.val);

            left = left.next;

            ListNode prev = head;

            while (prev.next != right) {
                prev = prev.next;
            }

            right = prev;
        }

        if (left == right) {
            record.add(left.val);
        } else {
            record.add(left.val);
            record.add(right.val);
        }

        ListNode curr = head;

        for (int val : record) {
            curr.val = val;
            curr = curr.next;
        }
    }
}