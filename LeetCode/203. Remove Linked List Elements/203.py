class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        
        # Create a dummy node to handle edge cases
        newList = ListNode(0)  # Create a new ListNode with value 0. This is a dummy node used as a placeholder.
        newList.next = head  # Set the next of the dummy node to be the head of the input list.
        current = newList  # Set the current node to be the dummy node.

        while current.next:  # While the next node of the current node is not None
            if current.next.val == val:  # If the value of the next node is equal to the target value
                current.next = current.next.next  # Skip the next node by setting the next of the current node to be the next of the next node.
            else:  # If the value of the next node is not equal to the target value
                current = current.next  # Move to the next node.

        return newList.next  # Return the next of the dummy node, which is the head of the modified list.
    

    '''

    # Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
       
        while head and head.val == val:
            head = head.next

        temp=head
        while temp and temp.next!=None:
            if temp.next.val==val:
              temp.next=temp.next.next
            else:
                temp=temp.next
        return head        

    '''

    '''
    # Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def removeElements(self, head, val):
        """
        :type head: ListNode
        :type val: int
        :rtype: ListNode
        """
        temp = ListNode(0)
        temp.next = head
        prev, curr = temp, head
        while curr:
            if curr.val == val:prev.next = curr.next
            else:prev = curr
            curr = curr.next
        return temp.next
    '''

    '''
    # Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        first = dummy
        current = head
        while current:
            if current.val==val:
                first.next = current.next
            else:
                first = current
            current = current.next
        return dummy.next
        
    '''