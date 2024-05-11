import heapq

class Solution(object):
    def mincostToHireWorkers(self, quality, wage, k):
        """
        :type quality: List[int]
        :type wage: List[int]
        :type k: int
        :rtype: float
        """
        n = len(quality)
        workers = sorted([(float(wage[i]) / quality[i], quality[i]) for i in range(n)])
        
        heap = []
        total_quality = 0
        min_wage = float('inf')
        
        for ratio, q in workers:
            total_quality += q
            heapq.heappush(heap, -q)  # Max heap for quality
            
            if len(heap) > k:
                total_quality += heapq.heappop(heap)
            
            if len(heap) == k:
                min_wage = min(min_wage, total_quality * ratio)
        
        return min_wage
