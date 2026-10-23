# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        # init an empty array containing result – mutable
        result = [root.val]

        # def: return max path sum without split and updates result with split
        def dfs(root):
            # if: root is None, return 0
            if not root:
                return 0

            # invoke itself on left subtree
            # take max(leftMax, 0)
            leftMax = dfs(root.left)
            leftMax = max(leftMax, 0)

            # invoke itself on right subtree
            # take max(rightMax, 0)
            rightMax = dfs(root.right)
            rightMax = max(rightMax, 0)

            # update result – max of path sum with split and prev.
            result[0] = max(result[0], (leftMax + root.val + rightMax))

            # return max path
            return root.val + max(leftMax, rightMax)

        # invoke dfs
        # return result
        dfs(root)
        return result[0]