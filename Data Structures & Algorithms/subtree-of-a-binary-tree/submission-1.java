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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Recursion...

        // Base case:
        // if root is null return false
        if (root == null)
            return false;

        // if root is the same as subroot
        if (isSameTree(root, subRoot))
            return true;

        // return true if left subtree or right subtree has the subRoot
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));   
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        return (isSameTree(root1.left, root2.left) && (root1.val == root2.val) && isSameTree(root1.right, root2.right));
    }
}
