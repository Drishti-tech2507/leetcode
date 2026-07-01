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
       int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dia;
    }
    private int height(TreeNode node)
    {
        if(node ==null)
        {
            return 0;
        }
        int lHeight = height(node.left);
        int rHeight = height(node.right);
        dia = Math.max(dia, lHeight + rHeight);
        return 1 + Math.max(lHeight, rHeight);
    }
}