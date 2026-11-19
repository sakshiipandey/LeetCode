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
    public int[] nextLargerNodes(ListNode head) {

        //  Linked List ko ArrayList mein convert 
        ArrayList<Integer> list = new ArrayList<>();

        while(head != null) {
            list.add(head.val);
            head = head.next;
        }

        int n = list.size();
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Next Greater Element
        for(int i = 0; i < n; i++) {

            while(!stack.isEmpty() &&
                  list.get(i) > list.get(stack.peek())) {

                int idx = stack.pop();

                res[idx] = list.get(i);
            }

            stack.push(i);
        }

        return res;
    }
}