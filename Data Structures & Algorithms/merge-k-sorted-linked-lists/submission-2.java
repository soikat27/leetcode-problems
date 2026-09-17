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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        
        // while: lists.length > 1
        //// initialize an empty newList
        //// loop: iterate index 0 through lists.length-1 with step size: 2. For every index i:
        ////// if i != lists.length-1: merge lists[i] and lists[i], and add to the newLists
        ////// push lists[i] to the newLists
        //// lists = newLists
        while (lists.length > 1) {
            List<ListNode> newLists = new ArrayList<>();

            for (int i = 0; i < lists.length; i = i+2) {
                if (i != lists.length-1) {
                    ListNode merged = merge(lists[i], lists[i+1]);
                    newLists.add(merged);
                }
                else
                    newLists.add(lists[i]);     
            }

            lists = newLists.toArray(new ListNode[0]);
        }

        // retrun lists[0]
        return lists[0];
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        // initialize dummy  – null ListNode
        // initialize tail – points to dummy
        // initialize l1 and l2 – l1 points to list1 head and l2 points to list2 head
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode l1 = list1;
        ListNode l2 = list2;

        // while: both l1 and l2 not null
        //// if (l1.value <= l2.value)
        ////// tail.next = l1
        ////// l1 = l1.next
        //// else:
        ////// tail.next = l2
        ////// l2 = l2.next
        //// tail = tail.next
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }

            tail = tail.next;
        }

        // if: l1 not null, tail.next = l1
        // else: tail.next = l2
        if (l1 != null)
            tail.next = l1;
        else
            tail.next = l2;

        // return dummy.next;
        return dummy.next;
    }
}
