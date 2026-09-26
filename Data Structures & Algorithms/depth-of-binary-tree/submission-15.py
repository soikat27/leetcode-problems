# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        # Iterative BFS...

        # init. an empty queue
        # if: root, append to the queue
        # init. level = 0
        queue = deque()
        if root:
            queue.append(root)
        level = 0

        # while queue:
        ## init. length = len(queue)
        ## iterate 0 through length-1
        ### popleft a node
        ### if node.left, append
        ### if node.right, append
        ## increment level
        while queue:
            length = len(queue)
            for i in range(length):
                node = queue.popleft()
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            level += 1

        # return level
        return level
