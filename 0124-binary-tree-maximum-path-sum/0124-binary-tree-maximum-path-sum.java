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
    int maxS = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        mps(root);
        return maxS;   
    }
    private int mps(TreeNode node)
    {
        if(node == null) return 0;
        int l = Math.max(0, mps(node.left));
        int r = Math.max(0, mps(node.right));
        int currentP = l + r + node.val;
        maxS = Math.max(maxS, currentP);
        return node.val + Math.max(l, r);
    }
}