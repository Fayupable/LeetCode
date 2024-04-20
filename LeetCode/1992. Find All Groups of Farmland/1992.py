class Solution:
    def findFarmland(self, land):
        """
        :type land: List[List[int]]
        :rtype: List[List[int]]
        """
        # Get the dimensions of the land matrix
        m = len(land)
        n = len(land[0])
        # Initialize an empty list to store the result
        result = []
        
        # Iterate through each cell in the land matrix
        for i in range(m):
            for j in range(n):
                # Check if the current cell represents farmland (1)
                if land[i][j] == 1:
                    # Initialize variables to track the top left and bottom right corners of the current group
                    r1, c1, r2, c2 = i, j, i, j
                    
                    # Find the bottom right corner of the current group
                    while r2 < m and land[r2][j] == 1:
                        r2 += 1
                    while c2 < n and land[i][c2] == 1:
                        c2 += 1
                    
                    # Mark the farmland of the current group as visited (set to 0)
                    for x in range(r1, r2):
                        for y in range(c1, c2):
                            land[x][y] = 0
                    
                    # Append the coordinates of the current group to the result list
                    result.append([r1, c1, r2 - 1, c2 - 1])
        
        # Return the list containing coordinates of all farmland groups
        return result
