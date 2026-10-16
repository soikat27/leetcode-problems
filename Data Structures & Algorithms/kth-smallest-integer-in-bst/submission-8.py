# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # init. empty stack
        # init. curNode to root
        # init. i to 0
        stack = []
        curNode = root
        i = 0

        # while: curNode or stack
        ## if: curNode
        #### push to the stack
        #### move curNode to left
        ## else:
        #### pop from the stack
        #### increment i
        #### if: i == k, return node.val
        #### move curNode to right
        while curNode or stack:
            if curNode:
                stack.append(curNode)
                curNode = curNode.left
            else:
                node = stack.pop()
                i += 1
                if i == k:
                    return node.val
                curNode = node.right

        # if exits, return -1
        return -1