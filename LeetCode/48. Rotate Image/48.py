class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """

        left =0
        right =len(matrix) -1

        while left < right:
            for i in range(right-left):
                top = left
                bottom = right

                holder = matrix[top][left+i]

                #swap bl tl br-bl 
                matrix[top][left+i] = matrix[bottom-i][left]

                matrix[bottom-i][left] = matrix[bottom][right-i]

                matrix[bottom][right-i] = matrix[top+i][right]

                matrix[top+i][right] = holder

            left +=1
            right -=1
            

'''
class Solution(object):
    def rotate(self, matrix):
        matrix[:] = zip(*matrix[::-1])
        
'''

'''
class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        
        # Transpose the matrix
        for i in range(n):
            for j in range(i, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
        
        # Reverse each row
        for i in range(n):
            matrix[i].reverse()
'''