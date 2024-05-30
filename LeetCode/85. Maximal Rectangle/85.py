class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix or not matrix[0]:
            return 0
        max_a=0
        n=len(matrix[0])
        heights=[0]*(n+1) 
        for row in matrix:
            for i in range(n):
                # If the current element is '1', increase the corresponding height by 1
                # otherwise reset the height to 0
                heights[i]=heights[i]+1 if row[i] =='1' else 0
            # Compute the maximum rectangle area using a stack-based method for histograms
            stack=[]
            for i in range(n+1):
                while stack and heights[i]<heights[stack[-1]]:
                    h=heights[stack.pop()]
                    # Calculate the width: if the stack is empty, use 'i' as the width
                    # otherwise, calculate width as the difference between current index and the last index in stack
                    w=i if not stack else i-stack[-1]-1
                    max_a=max(max_a,h*w)
                stack.append(i)
        return max_a