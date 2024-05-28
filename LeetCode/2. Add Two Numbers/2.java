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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize a dummy node to simplify handling the head of the result list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        
        // Traverse both lists
        while (l1 != null || l2 != null) {
            // Get the current values, if present
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            
            // Calculate the sum of current digits and carry
            int sum = carry + x + y;
            carry = sum / 10; // Update carry for next iteration
            
            // Create a new node with the digit part of sum and attach it to the result list
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            // Move to the next nodes in each list, if available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // If there's a carry left after the last addition, add it as a new node
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        // The real head of the result list is next to the dummy node
        return dummyHead.next;
    }
}
