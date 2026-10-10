# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        # define helper function, isValid(root, leftBound, rightBound). 
        # Contract: the function returns true if given root, leftBound and RightBound, the tree is valid
        def isValid(root, leftBound, rightBound):
            if not root:
                return True
            if not (root.val > leftBound and root.val < rightBound):
                return False
            
            return (isValid(root.left, leftBound, root.val) and isValid(root.right, root.val, rightBound))

        # return isValid passing root, neg. inf and pos. inf
        return isValid(root, float("-inf"), float("inf"))