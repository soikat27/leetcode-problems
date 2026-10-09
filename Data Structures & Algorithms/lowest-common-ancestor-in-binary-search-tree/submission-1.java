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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // initialize curLowest to root
        TreeNode curLowest = root;
        
        // while: curLowest not null
        //// if: either is a curLowest node or p, q in opposite subtree, return curLowest
        //// if: p < curLowest, curLowest = curLowest.left
        //// else: curLowest = curLowest.right
        while (curLowest != null) {
            if ( ((p == curLowest) || (q == curLowest)) ||
                 ((p.val < curLowest.val) && (q.val > curLowest.val)) || 
                 ((p.val > curLowest.val) && (q.val < curLowest.val)) ) {
                    return curLowest;
                }
            
            if (p.val < curLowest.val)
                curLowest = curLowest.left;
            else
                curLowest = curLowest.right;
        }

        // return curLowest
        return curLowest;
    }
}
