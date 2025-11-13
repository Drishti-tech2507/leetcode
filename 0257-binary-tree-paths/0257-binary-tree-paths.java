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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, "", result);
        return result;
    }

    private void helper(TreeNode node, String path, List<String> result) {
        if (node == null) return;
        
        // If path is empty, start with node value, else append -> and value
        if (path.isEmpty()) {
            path = Integer.toString(node.val);
        } else {
            path += "->" + node.val;
        }
        
        // If it's a leaf node, add path to result
        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }
        
        // Continue DFS on left and right subtrees
        helper(node.left, path, result);
        helper(node.right, path, result);
    }
}