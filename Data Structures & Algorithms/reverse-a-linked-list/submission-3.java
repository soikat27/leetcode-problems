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
    public ListNode reverseList(ListNode head) {
        // initialize prev = null, curr = head and if: head, next = head.next
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        if (head != null)
            next = head.next;

        // while: 
        //// assign cur.next to prev (reverse)
        //// update move forward prev, curr and next pointers(if: next) – sequence matters
        while (curr != null) {
            curr.next = prev;

            prev = curr;
            curr = next;
            if (next != null)
                next = next.next;
        }

        // update head – head points to prev
        // return head
        head = prev;
        return head;
    }
}
