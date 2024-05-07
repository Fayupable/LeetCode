class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def doubleIt(self, head):
        # Bağlı listeyi ters çevirme
        reversed_list = self.reverse_list(head)
        
        carry = 0
        current, previous = reversed_list, None
        
        # Ters çevrilen bağlı listeyi tarayarak ikiyle çarpma işlemi
        while current:
            new_value = current.val * 2 + carry
            current.val = new_value % 10
            carry = 1 if new_value > 9 else 0
            previous, current = current, current.next
        
        # Eğer işlem sonrasında carry varsa, ek bir düğüm eklenir
        if carry:
            previous.next = ListNode(carry)
        
        # Sonucu elde etmek için bağlı listeyi tekrar ters çevirme
        result = self.reverse_list(reversed_list)
        
        return result
    
    # Bağlı listeyi ters çeviren fonksiyon
    def reverse_list(self, node):
        previous, current = None, node
        
        while current:
            next_node = current.next
            current.next = previous
            previous, current = current, next_node
        
        return previous
