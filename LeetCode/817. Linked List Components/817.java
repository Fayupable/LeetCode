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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }

        int connectedComponents = 0;
        boolean inComponent = false;
        
        for (ListNode current = head; current != null; current = current.next) {
            if (numsSet.contains(current.val)) {
                if (!inComponent) {
                    connectedComponents++;
                    inComponent = true;
                }
            } else {
                inComponent = false;
            }
        }

        return connectedComponents;
    }
}
