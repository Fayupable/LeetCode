# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def mergeKLists(self, lists):
        """
        :type lists: List[ListNode]
        :rtype: ListNode
        """
        heap=[]
        for i,node in enumerate(lists):
            if node:
                heapq.heappush(heap,(node.val,i,node))

        dummy=tail=ListNode(0)
        while heap:
            val,i,node=heapq.heappop(heap)
            tail.next=node
            tail=tail.next
            node=node.next
            if node:
                heapq.heappush(heap,(node.val,i,node))
        return dummy.next

        