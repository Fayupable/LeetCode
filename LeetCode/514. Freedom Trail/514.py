class Solution(object):
    def findRotateSteps(self, ring, key):
        """
        :type ring: str
        :type key: str
        :rtype: int
        """
        def find_positions(ring, character):
            positions = []
            for i, char in enumerate(ring):
                if char == character:
                    positions.append(i)
            return positions
        
        def min_steps_to_position(ring, current_pos, target_pos):
            clockwise_steps = (target_pos - current_pos) % len(ring)
            anticlockwise_steps = (current_pos - target_pos) % len(ring)
            return min(clockwise_steps, anticlockwise_steps)
        
        def dp(ring_index, key_index, memo):
            if key_index == len(key):
                return 0
            
            if (ring_index, key_index) in memo:
                return memo[(ring_index, key_index)]
            
            min_steps = float('inf')
            for pos in find_positions(ring, key[key_index]):
                steps_to_position = min_steps_to_position(ring, ring_index, pos)
                steps_to_next_char = dp(pos, key_index + 1, memo)
                total_steps = steps_to_position + steps_to_next_char
                min_steps = min(min_steps, total_steps)
                
            memo[(ring_index, key_index)] = min_steps + 1  # Ekstra bir adım merkez düğmesine basmak için
            return min_steps + 1  # Bir sonraki karakteri işaretlemeden önce merkez düğmesine basılması gerektiği için +1
        
        return dp(0, 0, {})


#2
class Solution(object):
    def findRotateSteps(self, ring, key):
        """
        :type ring: str
        :type key: str
        :rtype: int
        """
        n, m = len(ring), len(key)
        dp = [[float('inf')] * n for _ in range(m)]
        pos = [[] for _ in range(26)]
        for i in range(n):
            pos[ord(ring[i]) - ord('a')].append(i)
        for i in pos[ord(key[0]) - ord('a')]:
            dp[0][i] = min(i, n - i) + 1
        for i in range(1, m):
            for j in pos[ord(key[i]) - ord('a')]:
                for k in pos[ord(key[i - 1]) - ord('a')]:
                    diff = abs(j - k)
                    dp[i][j] = min(dp[i][j], dp[i - 1][k] + min(diff, n - diff) + 1)
        return min(dp[m - 1])