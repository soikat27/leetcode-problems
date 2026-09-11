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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // initialize dummy and tail – dummy points to head
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        
        // while: both list1 and list2 are not null
        //// if l1.value <= l2.value: tail.next = l1, move tail forward, move l1 forward
        //// else: do similar tasks for the other
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            }
            else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // if l1 not null
        //// tail.next = l1
        // else: tail.next = l2
        if (list1 != null)
            tail.next = list1;
        else
            tail.next = list2;

        // retun dummy.next 
        return dummy.next;
    }
}