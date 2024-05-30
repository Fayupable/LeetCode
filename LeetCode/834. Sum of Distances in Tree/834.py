from collections import defaultdict

class Solution(object):
    def sumOfDistancesInTree(self, n, edges):
        # Step 1: Build adjacency list
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
        
        # Step 2: Calculate subtree sizes and initialize answer array
        subtree_size = [0] * n
        ans = [0] * n
        
        def dfs_subtree_size(node, parent):
            subtree_size[node] = 1
            for child in graph[node]:
                if child != parent:
                    dfs_subtree_size(child, node)
                    subtree_size[node] += subtree_size[child]
                    ans[node] += ans[child] + subtree_size[child]
        
        # Step 3: DFS to calculate subtree sizes and initial answer values
        dfs_subtree_size(0, -1)
        
        # Step 4: DFS to calculate distances
        def dfs_distances(node, parent):
            for child in graph[node]:
                if child != parent:
                    ans[child] = ans[node] - subtree_size[child] + (n - subtree_size[child])
                    dfs_distances(child, node)
        
        dfs_distances(0, -1)
        
        return ans

# Example usage:
solution = Solution()
n = 6
edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
print(solution.sumOfDistancesInTree(n, edges))
