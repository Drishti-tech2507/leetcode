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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }
    private void postorderHelper(TreeNode node, List<Integer>result)
    {
        if(node == null)return;
        postorderHelper(node.left, result);
        postorderHelper(node.right, result);
        result.add(node.val);
    }
    public static void main(String[]args)
    {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution obj = new Solution();
        System.out.println(obj.postorderTraversal(root));

    }
}