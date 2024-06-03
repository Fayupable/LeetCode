class Solution(object):
    def appendCharacters(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        i = 0  # Initialize a pointer for t
        for c in s:  # Iterate over the characters in s
            if i < len(t) and c == t[i]:  # If the current character in s is the same as the current character in t
                i += 1  # Increment the pointer for t
        return len(t) - i  # Return the number of characters that need to be appended to s
    
#other people's solutions
'''
class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        m, n = len(s), len(t)
        j = 0
        
        # Iterate through the string s
        for i in range(m):
            if j < n and s[i] == t[j]:
                j += 1
        
        # If all characters of t are found in s in the same order
        if j == n:
            return 0
        
        # Characters remaining in t that are not matched in s
        return n - j
'''

'''
class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        n = len(t)
        s_iter = iter(s)
        for i,c in enumerate(t):
            if c not in s_iter:
                return n-i
        return 0
'''
'''
class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        # get max subsequence
        # return len(t) - s

        m = 0
        j = 0

        for ch in s:
            if ch == t[j]:
                j += 1
                m += 1

                if j == len(t):
                    return 0
        
        return len(t) - m
'''
'''
class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        answ = 0
        i, j = 0, 0
        while i < len(s) and j < len(t):
            if s[i] == t[j]:
                i += 1
                j += 1
            elif s[i] != t[j]:
                i += 1
        appends = len(t) - j
        return appends
'''
'''
class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        it = iter(s)
        matching_count = sum(1 for char in t if char in it)
        return len(t) - matching_count
'''
'''
class Solution:
    def appendCharacters(self, s: str, t: str) -> int:
        leng_s = len(s); leng_t = len(t)
        i, j = 0, 0
        while leng_s > i and leng_t > j:
            if s[i] == t[j]: i += 1; j += 1
            else: i += 1
        return leng_t - j
'''