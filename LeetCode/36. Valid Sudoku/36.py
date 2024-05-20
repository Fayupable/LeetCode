class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        rows = [set() for _ in range(9)]
        cols = [set() for _ in range(9)]
        boxes = [set() for _ in range(9)]
        
        for i in range(9):
            for j in range(9):
                if board[i][j] != '.':
                    num = board[i][j]
                    boxIndex = (i // 3) * 3 + j // 3
                    
                    # Check if this value is already in the row, column, or box
                    if num in rows[i] or num in cols[j] or num in boxes[boxIndex]:
                        return False
                    
                    # Add the number to the current row, column, and box
                    rows[i].add(num)
                    cols[j].add(num)
                    boxes[boxIndex].add(num)
        
        return True
    

    '''
    class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        seen = set()
        for i in range(9):
            for j in range(9):
                current = board[i][j]
                if current != ".":
                    if (i, current) in seen or (current,j) in seen or (i//3,j//3,current) in seen:
                        return False
                    seen.add((i,current))
                    seen.add((current,j))
                    seen.add((i//3,j//3,current))
                
        return True
    '''