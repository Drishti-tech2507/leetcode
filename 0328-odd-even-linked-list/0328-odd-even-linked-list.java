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
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
        {
            return null;
        }
        ListNode odd = head;
        ListNode e = head.next;
        ListNode eHead = e;
        while(e != null && e.next != null)
        {
            odd.next = e.next;
            odd = odd.next;
            e.next = odd.next;
            e = e.next;
        }
        odd.next = eHead;
        return head;
    }
}