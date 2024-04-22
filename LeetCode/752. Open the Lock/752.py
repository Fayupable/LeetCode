class Solution:
    def openLock(self, deadends, target):
        deadends = set(deadends)
        if "0000" in deadends:
            return -1
        
        queue = deque([("0000", 0)])
        visited = set(["0000"])
        
        while queue:
            current, turns = queue.popleft()
            if current == target:
                return turns
            
            for i in range(4):
                for j in [-1, 1]:
                    next_wheel = current[:i] + str((int(current[i]) + j) % 10) + current[i+1:]
                    if next_wheel not in visited and next_wheel not in deadends:
                        queue.append((next_wheel, turns + 1))
                        visited.add(next_wheel)
        
        return -1