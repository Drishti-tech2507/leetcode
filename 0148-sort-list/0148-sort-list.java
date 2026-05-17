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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
        {
            return head;
        }
        ListNode s = head;
        ListNode f = head.next;
        while(f != null && f.next != null)
        {
            s = s.next;
            f = f.next.next;
        }
        ListNode mid = s.next;
        s.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(mid);
        return merge(l, r);
    }
    private ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode d = new ListNode(0);
        ListNode t = d;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                t.next = l1;
                l1 = l1.next;
            }
            else {
                t.next = l2;
                l2 = l2.next;
            }
            t = t.next;
        }
        if(l1 != null)
        {
            t.next = l1;
        }
        if(l2 != null)
        {
            t.next = l2;
        }
        return d.next;
    }
}