/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode node:lists){
            if(node!=null){
                queue.add(node);
            }
        }
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while(!queue.isEmpty()){
            ListNode minNode=queue.poll();
            tail.next=minNode;
            tail=tail.next;
            if(minNode.next!=null){
                queue.add(minNode.next);
            }
        }
        return dummy.next;

    }
}