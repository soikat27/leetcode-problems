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
        // Iterative approach...

        // create an empty stack
        // initialize curNode to root
        // initialize i to 0 – keeps track of ith smallest
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        int i = 0;

        // while: curr or stack
        //// if: curr
        ////// push to the stack
        ////// move curr to curr.left
        //// else:
        ////// pop from the stack
        ////// increment i
        ////// if: i ==k, return val of popped node
        ////// curNode = node.right
        while (curNode != null || !stack.isEmpty()) {
            if (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            else {
                TreeNode node = stack.pop();
                i++;
                if (i == k)
                    return node.val;
                
                curNode = node.right;
            }
        }

        // if exits, return -1
        return -1;
        
    }
}
