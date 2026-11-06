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

public class Codec {
    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // Recursive dfs – preorder

        // initialize an empty string
        StringBuilder result = new StringBuilder();

        // invoke dfs
        dfs1(result, root);

        // return result
        return result.toString().trim();
    }

    private void dfs1(StringBuilder result, TreeNode node) {
        // if node is null
        //// write N
        //// return
        if (node == null) {
            result.append(" N");
            return;
        }
        
        // write node.val
        // serialize node.left and node.right
        result.append(" " + node.val);
        dfs1(result, node.left);
        dfs1(result, node.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // initialize array from the data – split
        // init. curIndex to zero
        String[] array = data.split(" ");

        // invoke dfs
        TreeNode root = dfs2(array);

        // return root
        return root;
    }

    private TreeNode dfs2(String[] array) {
        // if array[index] is N:
        //// increment index
        //// return null
        if (array[index].equals("N")) {
            index++;
            return null;
        }

        // instantiate root
        // increment index – points to next val
        // call dfs for root.left
        // call dfs for root.right
        TreeNode root = new TreeNode(Integer.parseInt(array[index]));
        index++;
        root.left = dfs2(array);
        root.right = dfs2(array);

        // return root
        return root;
    }
}
