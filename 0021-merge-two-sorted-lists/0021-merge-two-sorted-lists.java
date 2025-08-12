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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the starting point
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        
        // Traverse both lists simultaneously
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        // Attach the remaining elements from either list
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        // The actual head is after the dummy node
        return dummy.next;
    }
}
