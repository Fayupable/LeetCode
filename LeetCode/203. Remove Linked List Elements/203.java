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
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to handle the case when the first node is to be removed
        ListNode newList = new ListNode(0); // Create a new ListNode with value 0. This is a dummy node used as a placeholder.
        newList.next = head; // Set the next of the dummy node to be the head of the input list.
        ListNode current = newList; // Set the current node to be the dummy node.
        
        while (current.next != null) { // While the next node of the current node is not null
            if (current.next.val == val) { // If the value of the next node is equal to the target value
                current.next = current.next.next; // Skip the next node by setting the next of the current node to be the next of the next node.
            } else { // If the value of the next node is not equal to the target value
                current = current.next; // Move to the next node.
            }
        }
        
        return newList.next; // Return the next of the dummy node, which is the head of the modified list.
    }
}


/*
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


    /*
     class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if( head == null)
         return null;
head.next = removeElements(head.next,val);
return head.val == val? head.next :head;
    }
}
     */

     /*
      class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null){
            if(head.val == val){
                head = head.next;
            }else{
                break;
            }
        }
        if(head == null) return null;
        ListNode current = head;
        while(current.next != null){
            if (current.next.val == val){
                current.next = current.next.next;
                continue;
            }
            current = current.next;
        }
        System.gc();
        return head;    
    }
}
      */