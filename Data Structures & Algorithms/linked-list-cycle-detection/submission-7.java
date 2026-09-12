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
    public boolean hasCycle(ListNode head) {
        // initialize slow and fast pointers – points to head node
        ListNode slow = head;
        ListNode fast = head;

        // while: (fast not null and fast.next not null)
        //// increment both pointers appropriately
        //// if: slow fast reaches slow, return true
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow)
                return true;
        }

        // return false
        return false;
    }
}
