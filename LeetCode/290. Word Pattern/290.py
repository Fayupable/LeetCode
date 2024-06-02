class Solution(object):
    def wordPattern(self, pattern, s):
        """
        :type pattern: str
        :type s: str
        :rtype: bool
        """
        
        s = s.split()
        if len(pattern) != len(s):
            return False
        dic = {}
        for i in range(len(pattern)):
            if pattern[i] in dic:
                if dic[pattern[i]] != s[i]:
                    return False
            else:
                if s[i] in dic.values():
                    return False
                dic[pattern[i]] = s[i]
        return True
    

'''
class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:

        answer_code = {}
        s_arr = s.split()
        if len(s_arr) != len(pattern):
            return False

        for i, char in enumerate(pattern):
            if char not in answer_code and s_arr[i] not in answer_code.values():
                answer_code[char] = s_arr[i]
            elif not (char in answer_code and s_arr[i] in answer_code.values() and answer_code[char] == s_arr[i]):
                return False
        return True 
            
'''
'''
class Solution(object):
    def wordPattern(self, pattern, s):
        s1 = s.split(" ")
        if len(pattern) != len(s1):
           return False
        d = {}
        for i in range(len(pattern)):
            try:
                if ((pattern[i] in d) or (s1[i] in d.values())) and (d[pattern[i]]  !=s1[i]):
                    return False
            except KeyError:
                return False
            if s1[i] not in d.values():
                d[pattern[i]] = s1[i]
        return True
        
'''
'''
class Solution(object):
    def wordPattern(self, pattern, s):
        """
        :type pattern: str
        :type s: str
        :rtype: bool
        """
        words=s.split(" ")
        if len(pattern)!=len(words):
            return False
        chartoword={}
        wordtochar={}
        
        for c,w in zip(pattern,words):
            if c in chartoword and chartoword[c]!=w:
                return False
            if w in wordtochar and wordtochar[w]!=c:
                return False
            chartoword[c]=w
            wordtochar[w]=c
        return True

            
'''
'''
class Solution:
  def wordPattern(self, pattern: str, str: str) -> bool:
    t = str.split()
    return [*map(pattern.index, pattern)] == [*map(t.index, t)]
'''
'''
class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:

        s = s.split(' ')
        if len(s)!=len(pattern): return False

        d = {}
        seen = set()
        seen_val = set()

        for i in range(len(s)):
            if pattern[i] in seen:
                if d[pattern[i]]!=s[i]: return False

            else:
                if s[i] not in seen_val:
                    seen.add(pattern[i])
                    seen_val.add(s[i])
                    d[pattern[i]] = s[i]
                else:
                    return False

        return True
'''

'''
from collections import Counter

class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        res={}
        cres={}
        char_count = Counter(pattern)
        print(char_count)
        pm = list(pattern)
        splitted_words = s.split()
        print("length", pm, splitted_words)
        if len(pm) != len(splitted_words):
            return False

        for cpos, word in enumerate(splitted_words):
            if word not in res:
                res[word] = {pm[cpos]: 1}
            else:
                print(pm, cpos, res, word)
                if pm[cpos] not in res[word]:
                    return False
                else:
                    res[word][pm[cpos]] += 1
        print("res", res)
        for cword in res:
            for char in res[cword]:
                if res[cword][char] != char_count[char]:
                    return False

        return True            
'''