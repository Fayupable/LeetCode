from collections import defaultdict, deque

class Solution(object):
    def findMinHeightTrees(self, n, edges):
        """
        :type n: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        if n == 1:
            return [0]
        
        # Graph construction
        graph = defaultdict(set)
        for u, v in edges:
            graph[u].add(v)
            graph[v].add(u)
        
        # Initialize leaves
        leaves = deque([node for node in range(n) if len(graph[node]) == 1])
        
        # Main loop until we have 1 or 2 nodes left
        while n > 2:
            # Exclude current leaves
            n -= len(leaves)
            new_leaves = deque()
            while leaves:
                leaf = leaves.popleft()
                neighbor = graph[leaf].pop()
                graph[neighbor].remove(leaf)
                if len(graph[neighbor]) == 1:
                    new_leaves.append(neighbor)
            leaves = new_leaves
        
        return list(leaves)


def test():
    n = 6
    edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]

    s = Solution()
    print(s.findMinHeightTrees(n, edges))

if __name__ == '__main__':
    test()
