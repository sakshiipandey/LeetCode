class Solution {

    public ListNode reverseLL(ListNode curr) {
        ListNode prev = null;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode slow = head,
                 fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = reverseLL(slow.next);
        slow.next = null;

        ListNode p1 = head;

        while(p1 != null && mid != null) {
            ListNode p1Next = p1.next,
                     midNext = mid.next;

            p1.next = mid;
            mid.next = p1Next;

            p1 = p1Next;
            mid = midNext;
        }
    }
}