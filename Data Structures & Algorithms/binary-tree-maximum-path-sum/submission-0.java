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
    public int maxPathSum(TreeNode root) {
        // init an array containting result – root.val; allows for mutatble
        int[] result = {root.val};

        // invoke dfs passing root, result
        dfs(root, result);

        // return result
        return result[0];
    }

    // returns the max path sum without split given a root
    private int dfs(TreeNode root, int[] result) {
        // if: root is null, return 0
        if (root == null)
            return 0;

        // find max path sum on left subtree
        // take max of (0, max(left))
        int leftMax = dfs(root.left, result);
        leftMax = Math.max(leftMax, 0);

        // find max path sum on right subtree
        // take max of (0, max(right))
        int rightMax = dfs(root.right, result);
        rightMax = Math.max(rightMax, 0);

        // update result – max path sum with split
        result[0] = Math.max(result[0], (leftMax + root.val + rightMax));

        // return max(leftMax, rightMax) + root.val
        return root.val + Math.max(leftMax, rightMax);
    }
}
