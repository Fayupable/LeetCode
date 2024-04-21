import collections # deque için
from collections import defaultdict, deque


class Solution(object):
    def validPath(self, n, edges, source, destination):
        # Graph'ı temsil etmek için bir kelime dizini oluştur
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)  # Çift yönlü bir graf olduğunu düşünerek
        
        # BFS uygula
        queue = deque([source])
        visited = set()
        visited.add(source)
        
        while queue:
            current = queue.popleft()
            if current == destination:
                return True  # Bir yol bulundu
            for neighbor in graph[current]:
                if neighbor not in visited:
                    visited.add(neighbor)
                    queue.append(neighbor)
        
        return False  # Yol bulunamadı