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
class Solution {

    public ListNode swapNodes(ListNode head, int k) {

        ListNode f = head;

        for (int i = 1; i < k; i++) {
            f = f.next;
        }
        ListNode kthFromStart = f;
        ListNode s = head;
        while (f.next != null) {
            f = f.next;
            s = s.next;
        }
        int temp = kthFromStart.val;
        kthFromStart.val = s.val;
        s.val = temp;
        return head;
    }
}