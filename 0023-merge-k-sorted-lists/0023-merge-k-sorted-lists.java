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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (true) {
            int p = -1; // index of smallest node
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (p == -1 || lists[i].val < lists[p].val) {
                        p = i;
                    }
                }
            }
            if (p == -1) break; // all lists are empty

            temp.next = lists[p];
            temp = temp.next;
            lists[p] = lists[p].next;
        }

        return dummy.next;
    }
}