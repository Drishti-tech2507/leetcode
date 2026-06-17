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
    private int postI;
    private Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);

        }
        postI = postorder.length - 1;
        return construct(postorder, 0, inorder.length - 1);

    }
    private TreeNode construct(int[] postorder, int left, int right) {
        if (left > right) {
            return null;

        }
        int rootV = postorder[postI--];
        TreeNode root = new TreeNode(rootV);
        int inorderI = inorderMap.get(rootV);
        root.right = construct(postorder, inorderI + 1, right);
        root.left = construct(postorder, left, inorderI- 1);
        return root;
    }
}