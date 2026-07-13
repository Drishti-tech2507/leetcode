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
    private int c;
    private int ans;
    public int kthSmallest(TreeNode root, int k) {
        c = k;
        inorder(root);
        return ans;
    }
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        c--;
        if(c == 0) {
            ans = node.val;
            return;
        }
        inorder(node.right);
    }
}