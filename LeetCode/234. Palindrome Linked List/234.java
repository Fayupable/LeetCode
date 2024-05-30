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
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        ListNode fast=head,slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;


        }
        ListNode mid=reverseList(slow);
        ListNode p1=head,p2=mid;
        boolean isPalindrome = true;
        while(p2!=null){
            if(p1.val!=p2.val){
                isPalindrome=false;
                break;
            }
            p1=p1.next;
            p2=p2.next;
        }
        reverseList(mid);
        return isPalindrome;
        
    }
     private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
     }

}