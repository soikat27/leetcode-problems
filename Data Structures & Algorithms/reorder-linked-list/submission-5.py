# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        # 1. middle mid_node
        # initialize slow and fast pointers
        # while: fast not None and fast.next not None
        ## increment slow and fast accordingly
        slow, fast = head, head.next
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # 2. reverse the latter half
        # initialize curr = slow.next, prev = null
        # slow.next = None
        # while curr != None
        ## next = curr.next
        ## curr.next = prev
        ## prev = curr, curr = next
        curr = slow.next
        prev = slow.next = None
        while curr:
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next

        # 3. reorder and merge both halves
        # initialize first and second
        # while: second is not None
        ## temp1 = first.next, temp2 = second.next
        ## first.next = second
        ## second.next = temp1
        ## first = temp1, second = temp2
        first, second = head, prev
        while second:
            temp1, temp2 = first.next, second.next
            first.next = second
            second.next = temp1
            first, second = temp1, temp2


