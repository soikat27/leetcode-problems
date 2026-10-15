# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        # initialize empty array with arr[0] = k and arr[1] = 0
        metaData = [k, 0]

        # call dfsInorder, passing root, array
        self.dfsInorder(root, metaData)

        # return array[1]
        return metaData[1]
    
    def dfsInorder(self, root, array):
        # if root is null, return
        if not root:
            return
        # call itself, passing root.left and array
        self.dfsInorder(root.left, array)

        # if: arr[0] = 0 – i.e returnVal found in left subtree, return
        # decrement arr[0]
        # if: arr[0] = 0, store root.val in arr[1] and return
        if (array[0] == 0):
            return

        array[0] -= 1
        if (array[0] == 0):
            array[1] = root.val
            return

        # call itself, passing root.right and array
        self.dfsInorder(root.right, array)
        