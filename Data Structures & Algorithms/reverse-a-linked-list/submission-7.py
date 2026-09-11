# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # initialize prev and curr pointers
        prev_node, curr_node = None, head

        # while: curr not null
        ## init. next_node – points to curr.next
        ## reverse pointer of curr – curr.next = prev
        ## prev points to curr
        ## curr points to next_node
        while curr_node is not None:
            next_node = curr_node.next
            curr_node.next = prev_node

            prev_node = curr_node
            curr_node = next_node

        # set head to prev_node
        # return head
        head = prev_node
        return head