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
        // Create a dummy node that will act as the starting point of the merged list
        ListNode dummy = new ListNode(-1);
        // This tail will point to the last node of the merged list
        ListNode tail = dummy;
        
        // Compare the heads of both lists and append the smaller one
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next; // Move the tail pointer forward
        }
        
        // Attach the remaining part of the list that is not null
        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }
        
        // Return the head of the merged list, which is the next of dummy
        return dummy.next;
    }
}