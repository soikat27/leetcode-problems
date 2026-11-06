# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        # initialize empty array – holds node vals
        result = [];

        # def: dfs(array) traverses preorder and populate the array – returns void
        # invoke dfs()
        def dfs(node):
            # if node is None:
            ## append "N"
            if not node:
                result.append("N")
                return

            # append node.val
            # call dfs on left subtree
            # call dfs on right subtree
            result.append(str(node.val))
            dfs(node.left)
            dfs(node.right)

        dfs(root)

        # join by " " and return the string
        return " ".join(result)
        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        # initialize data to array – split by " "
        # instantiate global index to zero
        array = data.split(" ")
        self.index = 0

        # def: dfs() given array, and index builds tree through preorder traversal and retuns root
        # call dfs(), get root
        def dfs():
            # if array[index] equals "N"
            ## increment index
            ## return None
            if array[self.index] == "N":
                self.index += 1
                return None

            # create root from array[index]
            # increment index
            # call dfs to build left subtree
            # call dfs to build right subtree
            root = TreeNode(int(array[self.index]))
            self.index += 1
            root.left = dfs()
            root.right = dfs()

            # return root
            return root
        
        root = dfs()

        # return root
        return root
