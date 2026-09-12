# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        # init. slow and fast pointers
        slow = head
        fast = head

        # while: (fast is not null and fast.next is not null)
        ## increment slow and fast pointers by 1 and 2 respectively
        ## if: slow is fast, retutn true
        while fast is not None and fast.next is not None:
            slow = slow.next
            fast = fast.next.next

            if slow is fast:
                return True

        ## return false
        return False