# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNodes(self, head):
        if not head:
            return None
        
        # Recursively remove nodes starting from the next node
        next_node = self.removeNodes(head.next)

        # Link the current node to the result of the recursive call
        head.next = next_node

        # Decide whether to keep the current node or skip it
        if next_node is None or head.val >= next_node.val:
            return head
        else:
            return next_node

# Helper function to create and print the list
def create_list(values):
    if not values:
        return None
    head = ListNode(values[0])
    current = head
    for value in values[1:]:
        current.next = ListNode(value)
        current = current.next
    return head