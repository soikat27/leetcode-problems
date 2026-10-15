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
    public int kthSmallest(TreeNode root, int k) {
        // Recursive approach...

        // initialize an empty array of size 2. arr[0] = k – decrements every time a node is visited. arr[1] stores kthSmallest – initialized with 0.
        int[] metaData = new int[2];
        metaData[0] = k;

        // invode dfsInorder(root, array)
        dfsInorder(root, metaData);

        // retrun array[1]
        return metaData[1];
    }

    // contract: traverse inorder dfs and given root and arr[k, 0], store kthSmallest value in arr[1].
    private void dfsInorder(TreeNode root, int[] arr) {
        // if root == null, return
        if (root == null)
             return;

        // call itself on root.left, arr
        dfsInorder(root.left, arr);

        // if: arr[0] == 0 – already found in left subtree, return 
        // decrement arr[0]
        // if arr[0] == 0, write root.val in arr[1]
        if (arr[0] == 0)
            return;

        arr[0]--;
        if (arr[0] == 0)
            arr[1] = root.val;

        // call itself on root.right, arr
        dfsInorder(root.right, arr);
    }
}
