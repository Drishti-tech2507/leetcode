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
    public ListNode partition(ListNode head, int x) {
         ListNode bHead = new ListNode(0);
        ListNode aHead = new ListNode(0);
        ListNode b = bHead;
        ListNode a = aHead;
        while(head != null)
        {
            if(head.val < x)
            {
                b.next = head;
                b = b.next;
            }
            else {
                a.next = head;
                a = a.next;
            }
            head = head.next;
        }
        a.next = null;
        b.next = aHead.next;
        return bHead.next;
    }
    public void printList (ListNode head)
    {
        while(head != null)
        {
            System.out.print(head.val + "->");
        }
    }
}