from collections import Counter
import heapq

class Solution(object):
    def isNStraightHand(self, hand, groupSize):
        """
        :type hand: List[int]
        :type groupSize: int
        :rtype: bool
        """
        if len(hand) % groupSize != 0:
            return False
        
        # Count the frequency of each card
        count = Counter(hand)
        
        # Create a min-heap from the card values
        min_heap = list(count.keys())
        heapq.heapify(min_heap)
        
        while min_heap:
            first = min_heap[0]  # Get the smallest card
            # Try to create a group starting from the smallest card
            for i in range(first, first + groupSize):
                if i not in count:
                    return False
                count[i] -= 1
                if count[i] == 0:
                    if i != min_heap[0]:
                        return False
                    heapq.heappop(min_heap)
        
        return True


# other people's solution
'''
class Solution(object):
    def isNStraightHand(self, hand, groupSize):
        hand.sort()
        i = 0
        while i < len(hand):
            if hand[i] is None:
                i += 1
                continue
            start = hand[i]
            count = 0
            j = i
            while j < len(hand) and count < groupSize:
                if hand[j] is None:
                    j += 1
                    continue
                if hand[j] == start + count - 1:
                    j += 1
                    continue
                if hand[j] > start + count:
                    return False
                count += 1
                hand[j] = None
                j += 1
            if count < groupSize:
                return False
        return True
'''
'''
class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0:
            return False
        
        # Count the frequency of each card
        count = Counter(hand)
        
        # Sort the cards
        sorted_hand = sorted(count.keys())
        
        # Iterate over sorted cards
        for card in sorted_hand:
            while count[card] > 0:
                # Try to form a group starting from this card
                for i in range(groupSize):
                    if count[card + i] > 0:
                        count[card + i] -= 1
                    else:
                        return False
        
        return True
        
'''