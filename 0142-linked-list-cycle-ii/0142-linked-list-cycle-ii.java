public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                break;
            }
        }

        // No cycle
        if(fast == null || fast.next == null) {
            return null;
        }

        ListNode n1 = head;
        ListNode n2 = slow;

        while(n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }
}