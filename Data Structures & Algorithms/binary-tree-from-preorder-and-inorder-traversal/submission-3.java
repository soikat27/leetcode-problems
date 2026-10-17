/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Recursive approach...

        // if: preorder.length is zero, return null
        if (preorder.length == 0)
            return null;

        // find index of root from inorder – loop
        // init. root treeNode
        int rootVal = preorder[0];
        int rootIndex = 0;
        for (; rootIndex < inorder.length; rootIndex++) {
            if (inorder[rootIndex] == rootVal)
                break;
        }
        TreeNode root = new TreeNode(rootVal);

        // find leftsubtree size
        // slice lpreorder – (1, leftsize+1)
        // slice linorder – (0, leftsize)
        
        // call itself, build left subtree
        int leftSize = rootIndex;
        int[] lpreorder = Arrays.copyOfRange(preorder, 1, leftSize+1);
        int[] linorder = Arrays.copyOfRange(inorder, 0, leftSize);
        root.left = buildTree(lpreorder, linorder);

        // slice rpreorder – (leftsize+1, end)
        // slice rinorder – (leftsize+1, end)
        // call itself, build right subtree
        int[] rpreorder = Arrays.copyOfRange(preorder, leftSize+1, preorder.length);
        int[] rinorder = Arrays.copyOfRange(inorder, leftSize+1, inorder.length);
        root.right = buildTree(rpreorder, rinorder);

        // return root
        return root;
    }
}
