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
    int c = 0;
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return c;
    }
     private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        // Get sum and count from left subtree
        int[] left = dfs(root.left);
        // Get sum and count from right subtree
        int[] right = dfs(root.right);
        // To Calculate sum of current subtree
        int sum = left[0] + right[0] + root.val;
        // To Calculate number of nodes in current subtree
        int nodes = left[1] + right[1] + 1;
        // Check current node equals subtree average
        if (sum / nodes == root.val) {

            c++;

        }

        return new int[]{sum, nodes};
     }
}