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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        if (head.next == null) {
            return head;
        }
        
        if (k == 0) {
            return head;
        }
        
        ListNode current = head;
        int length = 1; 

        while (current.next != null) {
            current = current.next;
            length++;
        }
        
        current.next = head;

        k = k % length;
        
        if (k == 0) {
            current.next = null; // Break the circular link
            return head;
        }
        
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        
        newTail.next = null;
        
        return newHead;
    }
}