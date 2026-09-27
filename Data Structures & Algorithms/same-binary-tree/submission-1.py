# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        # Recursion...

        # Base case:
        # if: p and q are None, return true
        if not p and not q:
            return True
        if (p and not q) or (not p and q):
            return False

        # return true if leftsubtrees, both roots, and right subtress are equal
        return (self.isSameTree(p.left, q.left) and (p.val == q.val) and self.isSameTree(p.right, q.right))
