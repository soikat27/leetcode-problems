# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        # initialize curLowest to root
        curLowest = root
        
        # while: curLowest not None
        ## if: p and q in left subtree, move curLowest to left
        ## elif: p and q in right subtree, move curLowest to right
        ## else (if p or q is curLowest or both in opposite subtree): retrun curLowest
        while curLowest:
            if p.val < curLowest.val and q.val < curLowest.val:
                curLowest = curLowest.left
            elif p.val > curLowest.val and q.val > curLowest.val:
                curLowest = curLowest.right
            else:
                return curLowest

        # return curLowest
        return curLowest