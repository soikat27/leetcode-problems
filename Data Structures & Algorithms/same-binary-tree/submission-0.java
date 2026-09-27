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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Recursion...

        // Base case:
        // if: both p and q are null, return true
        // if: only one is null, return false
        if (p == null && q == null)
            return true;
        if((p == null && q != null) || (p != null && q == null))
            return false;

        // return true if left subtrees, the root, and rightsubtress, all are the same, false otherwise
        return (isSameTree(p.left, q.left) && (p.val == q.val) && isSameTree(p.right, q.right));
    }
}
