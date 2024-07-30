class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        def is_isomorphic(s, t):
            return len(set(zip(s, t))) == len(set(s)) == len(set(t))
        
        return is_isomorphic(s, t) and is_isomorphic(t, s)
    

#other people's solution
'''
class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """

        if len(s) != len(t):
            return False
        
        letter_map = {}
        
        for i in range(len(s)):
            if s[i] in letter_map:
                if letter_map[s[i]] == t[i]:
                    continue
                else:
                    return False
            else:
                if t[i] in letter_map.values():
                    return False
                else:
                    letter_map[s[i]] = t[i]
        
        return True
'''