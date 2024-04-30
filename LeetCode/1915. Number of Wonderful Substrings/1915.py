class Solution(object):
    def wonderfulSubstrings(self, word):
        count = [0] * 1024  # Stores count of substrings with each bitmask
        count[0] = 1  # Initialize count for empty substring
        mask = 0
        result = 0

        for c in word:
            mask ^= 1 << (ord(c) - ord('a'))  # Toggle the bit corresponding to the current character
            result += count[mask]  # Add count of substrings with the current bitmask

            # Check substrings with one bit different from the current bitmask
            for i in range(10):
                result += count[mask ^ (1 << i)]

            count[mask] += 1  # Increment count for the current bitmask

        return result
