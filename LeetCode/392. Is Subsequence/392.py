class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        if len(s) == 0:  # If s is empty, it is a subsequence of any string, so return true
            return True
        
        i = 0  # Initialize a pointer for s
        for c in t:  # Iterate over the characters in t
            if c == s[i]:  # If the current character in t is the same as the current character in s
                i += 1  # Increment the pointer for s
                if i == len(s):  # If the pointer for s has reached the end of s, return true
                    return True
        return False  # If the loop finishes and the pointer for s has not reached the end of s, return false
    
'''
class Solution(object):
    def isSubsequence(self, s, t):
        it = iter(t)
        return all(char in it for char in s)


        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
'''
'''
class Solution(object):
    def isSubsequence(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        s_i = 0
        t_i = 0

        while s_i < len(s) and t_i < len(t):
            if t[t_i] != s[s_i]:
                t_i += 1
            else:
                t_i += 1
                s_i += 1
        
        return s_i == len(s)
'''

'''
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        i,j=0,0
        if len(s)>len(t):
            return False
        if len(s)=="":
            return True
        while i<len(s) and j<len(t):
            if s[i]==t[j]:
                i+=1
                j+=1
            else:
                j+=1
        return i==len(s)    

        
'''