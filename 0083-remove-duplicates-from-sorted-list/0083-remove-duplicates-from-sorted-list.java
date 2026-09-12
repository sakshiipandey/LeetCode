/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        if(head == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = first.next;

        while(second != null) {

            if(first.val == second.val) {
                first.next = second.next;
                second = second.next;
            } 
            else {
                first = first.next;
                second = second.next;
            }
        }

        return head;
    }
}