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
    public ListNode removeNodes(ListNode head) {
        // Base case: if the head is null, return null
        if (head == null) {
            return null;
        }

        // Recursively remove nodes from the rest of the list
        ListNode nextNode = removeNodes(head.next);

        // Link the current node to the recursive result
        head.next = nextNode;

        // Check if the current node should be included in the result:
        // If the nextNode is null, this means the current node is the last one in processed order and should be included.
        // If the current node's value is greater than or equal to nextNode's value, it means there is no higher value to the right.
        if (nextNode == null || head.val >= nextNode.val) {
            return head;
        } else {
            // Otherwise, we skip the current node and return the nextNode, effectively removing the current node.
            return nextNode;
        }
    }
}