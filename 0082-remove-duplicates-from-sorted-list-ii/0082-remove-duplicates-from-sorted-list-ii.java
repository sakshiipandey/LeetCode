class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = head;

        while(second != null) {

            if(second.next != null && second.val == second.next.val) {

                int duplicate = second.val;

                while(second != null && second.val == duplicate) {
                    second = second.next;
                }

                first.next = second;

            } else {
                first = first.next;
                second = second.next;
            }
        }

        return dummy.next;
    }
}