# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        # if: lists is empty return null
        if not lists:
            return None
        
        # while:
        ## initialize a newLists - holds all merged lists 
        ## loop: iterate index 0 through len(list)-1, with step size = 2
        #### extract list1 = list[i], list2 = list[i+1] if i != len(lists)-1 else null
        #### merge list[i] and list[i+1]
        #### append mergedList to the newLists
        ## lists = newLists
        while len(lists) > 1:
            newLists = []
            for i in range(0, len(lists), 2):
                list1 = lists[i]
                list2 = lists[i+1] if i != len(lists)-1 else None
                merged = self.merge(list1, list2)
                newLists.append(merged)
            
            lists = newLists

        # return lists[0]
        return lists[0]
    
    def merge(self, list1, list2):
        # initialize dummy and tail
        # initialize l1 and l2 – points to both list's head
        dummy = ListNode()
        tail = dummy
        l1, l2 = list1, list2

        # while: l1 and l2 not none
        ## if l1.val <= l2.val:
        #### tail.next = l1
        #### l1 = l1.next
        ## else:
        #### tail.next = l2
        #### l2 = l2.next
        ## tail = tail.next
        while l1 and l2:
            if l1.val <= l2.val:
                tail.next = l1
                l1 = l1.next
            else:
                tail.next = l2
                l2 = l2.next

            tail = tail.next

        # if l1 is not null: tail.next = l1
        # else: tail.next = l2
        if l1:
            tail.next = l1
        else:
            tail.next = l2
        
        # return dummy.next
        return dummy.next

