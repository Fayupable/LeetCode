
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
    public ListNode mergeNodes(ListNode head) {
        // Create a dummy node to act as the starting point of the result list
        ListNode dummy = new ListNode(0);
        ListNode currentResult = dummy;
        
        // Start from the node after the first zero
        ListNode current = head.next;
        
        int sum = 0; // Initialize the sum variable to accumulate values
        
        // Traverse the linked list
        while (current != null) {
            if (current.val != 0) {
                // Accumulate the sum if the current node is not zero
                sum += current.val;
            } else {
                // If current node is zero and there was a non-zero segment
                if (sum != 0) {
                    // Create a new node with the sum and attach it to the result list
                    currentResult.next = new ListNode(sum);
                    currentResult = currentResult.next;
                    // Reset sum for the next segment
                    sum = 0;
                }
            }
            // Move to the next node
            current = current.next;
        }
        
        // Return the next of dummy node which is the head of the new modified list
        return dummy.next;
    }
}