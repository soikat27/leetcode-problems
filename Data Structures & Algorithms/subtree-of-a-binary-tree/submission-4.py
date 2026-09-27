# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:   
    def isSubtree(self, root: Optional[TreeNode], subRoot: Optional[TreeNode]) -> bool:
        # Recursion...
        
        # Base case:
        # if: root is None, return false
        # if: root is the same tree as subRoot, return true
        if not root:
            return False
        if self.isSameTree(root, subRoot):
            return True

        # return true if subRoot is either in root's left or right subtree
        return (self.isSubtree(root.left, subRoot) or self.isSubtree(root.right, subRoot))

    def isSameTree(self, root1, root2):
        if not root1 and not root2:
            return True
        if not root1 or not root2:
            return False

        return (self.isSameTree(root1.left, root2.left) and (root1.val == root2.val) and self.isSameTree(root1.right, root2.right))
