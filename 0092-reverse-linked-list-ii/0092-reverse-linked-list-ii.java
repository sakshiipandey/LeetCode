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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode first = head;
        ListNode second = head;

        for(int i = 1; i < left; i++) {
            first = first.next;
        }

        for(int i = 1; i < right; i++) {
            second = second.next;
        }

        while(left < right) {

            int temp = first.val;
            first.val = second.val;
            second.val = temp;

            first = first.next;
            left++;
            right--;

            second = head;
            for(int i = 1; i < right; i++) {
                second = second.next;
            }
        }

        return head;
    }
}