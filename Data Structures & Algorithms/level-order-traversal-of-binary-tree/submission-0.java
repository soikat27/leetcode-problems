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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // initialize an empty list of lists<Integer>
        List<List<Integer>> list = new ArrayList<>();

        // initialize a queue and offer root, if root
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root != null)
            queue.offer(root);

        // while: queue not empty
        //// get current queue size
        //// initilaize an empty list<Integer>
        //// loop: iterate 0 through size-1
        ////// poll a node and offer its value to the list
        ////// offer its children to the queue
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> curLevel = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);

                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            list.add(curLevel);
        }

        // return list
        return list;
    }
}
