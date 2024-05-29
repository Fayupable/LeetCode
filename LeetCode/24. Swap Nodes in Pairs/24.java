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
    public ListNode swapPairs(ListNode head) {
        // Edge case: if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Create a dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        // Initialize pointers
        ListNode prev = dummy;
        ListNode current = head;
        
        // Step 3: Iterate through the list and swap pairs
        while (current != null && current.next != null) {
            // Save next node
            ListNode next = current.next;
            
            // Swapping
            current.next = next.next;
            next.next = current;
            prev.next = next;
            
            // Moving pointers forward
            prev = current;
            current = current.next;
        }
        
        // Step 4: Return the new head
        return dummy.next;
    }
}