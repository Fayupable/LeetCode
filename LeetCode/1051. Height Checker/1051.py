class Solution(object):
    def heightChecker(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        c=0
        l=sorted(heights)
        for i in range(len(heights)):
            if l[i]!=heights[i]:
                c+=1
        return c


        
        '''
        class Solution(object):
    def heightChecker(self, heights):
        """
        :type heights: List[int]
        :rtype: int
        """
        def quick_sort(arr):
            if len(arr) <= 1:
                return arr
            pivot = arr[len(arr) // 2]
            left = [x for x in arr if x < pivot]
            middle = [x for x in arr if x == pivot]
            right = [x for x in arr if x > pivot]
            return quick_sort(left) + middle + quick_sort(right)

        sorted_heights = quick_sort(heights)
        return sum(h1 != h2 for h1, h2 in zip(heights, sorted_heights))
        '''