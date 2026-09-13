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
    public void reorderList(ListNode head) {
        // 1. find midpoint of the list
        // initialize slow and fast pointers – slow at head, fast head.next
        // while: fast not null and fast.next not null
        //// increment both pointers
        // midnode points to null, increment midpoint by 1 step
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;

        // 2. reverse the latter half
        // init prev = null and curr to slow
        // while (curr not null):
        //// curr.next = prev
        //// increment both prev and curr
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // 3. create the alternating list
        // init left pointer to left head, right pointer to right list lead
        // while (left not null or right not null)
        //// if left: tail.next = left, tail = tail.next
        //// if right: tail.next = right, tail = tail.next
        ListNode left = head;
        ListNode right = prev;
        while (left != null || right != null) {
            ListNode next = left.next;
            if (left != null) {
                left.next = right;
                left = next;
            }
            if (right != null) {
                ListNode temp = right.next;
                right.next = next;
                right = temp;
            }   
        }
    }
}
