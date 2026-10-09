# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        # initialize an empty list
        list = []

        # initialize empty queue and append root, if root
        queue = deque()
        if root:
            queue.append(root)

        # while: queue
        ## initialize empty level list
        ## get queue length
        ## loop: iterate 0 through length-1
        #### popleft curNode and append its value to level list
        #### append its children to queue
        ## append level list to list
        while queue:
            level = []
            size = len(queue)

            for _ in range(size):
                node = queue.popleft()
                level.append(node.val)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            list.append(level)

        # return list
        return list