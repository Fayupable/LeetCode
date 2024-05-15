from heapq import heappop, heappush
from collections import deque

class Solution(object):
    def maximumSafenessFactor(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        n = len(grid)
        if grid[0][0] == 1 or grid[n-1][n-1] == 1:
            return 0
        
        # Step 1: Calculate minimum distance to any thief using multi-source BFS
        dist = [[float('inf')] * n for _ in range(n)]
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        queue = deque()
        
        # Initialize queue with all thief positions
        for r in range(n):
            for c in range(n):
                if grid[r][c] == 1:
                    queue.append((r, c))
                    dist[r][c] = 0
        
        while queue:
            r, c = queue.popleft()
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < n and dist[nr][nc] == float('inf'):
                    dist[nr][nc] = dist[r][c] + 1
                    queue.append((nr, nc))
        
        # Step 2: Use Dijkstra's algorithm to find the path with the maximum safeness factor
        max_heap = [(-dist[0][0], 0, 0)]
        max_safeness = 0
        visited = [[False] * n for _ in range(n)]
        
        while max_heap:
            safeness, r, c = heappop(max_heap)
            safeness = -safeness
            
            if r == n - 1 and c == n - 1:
                max_safeness = max(max_safeness, safeness)
                break
            
            if visited[r][c]:
                continue
            
            visited[r][c] = True
            
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < n and not visited[nr][nc]:
                    heappush(max_heap, (-min(safeness, dist[nr][nc]), nr, nc))
        
        return max_safeness
