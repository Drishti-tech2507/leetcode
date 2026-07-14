/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
        
            return null;
        
        if (head.next == null)
        
            return new TreeNode(head.val);
            ListNode prev = null;
            ListNode s = head;
            ListNode f = head;
             while (f != null && f.next != null)
             {
                prev = s;
                s = s.next;
                f = f.next.next;
             }
             prev.next = null;
             TreeNode root = new TreeNode(s.val);
             root.left = sortedListToBST(head);
             root.right = sortedListToBST(s.next);
        return root;
    }
}