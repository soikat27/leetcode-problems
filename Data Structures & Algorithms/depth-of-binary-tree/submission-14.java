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
    public int maxDepth(TreeNode root) {
        // Iterative BFS...

        // init. an empty queue
        // if: root isn't null, offer root to the queue
        // init. level = 0
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.offer(root);
        int level = 0;

        // while:
        //// itearte through the queue via index.
        ////// push [index].left and [index].right if present
        //// increment level
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            level++;
        }

        // return level
        return level;
    }
}
