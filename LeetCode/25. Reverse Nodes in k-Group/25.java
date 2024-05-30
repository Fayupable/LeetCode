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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node to handle the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Count the total number of nodes in the list
        int count = 0;
        ListNode ptr = head;
        while (ptr != null) {
            ptr = ptr.next;
            count++;
        }

        ListNode prev = dummy, curr, next, tail;
        while (count >= k) {
            curr = prev.next; // The current node to be processed
            tail = prev.next; // Tail of the reversed part
            for (int i = 1; i < k; i++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = tail;
            count -= k;
        }
        return dummy.next;
    }
}