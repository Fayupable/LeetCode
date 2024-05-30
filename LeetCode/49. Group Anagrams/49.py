class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        anagrams = defaultdict(list)
        
        for word in strs:
            # Sort the word to create the key
            sorted_word = ''.join(sorted(word))
            # Append the word to the corresponding anagram group
            anagrams[sorted_word].append(word)
        
        # Return all the anagram groups as a list of lists
        return list(anagrams.values())
'''
class Solution:
    def groupAnagrams(self, strs):
        anagram_map = defaultdict(list)
        
        for word in strs:
            sorted_word = ''.join(sorted(word))
            anagram_map[sorted_word].append(word)
        
        return list(anagram_map.values())
'''
'''
f = open('user.out', 'w')
for strs in map(loads, stdin):
    w = defaultdict(list)
    for s in strs:
        w[''.join(sorted(s))].append(s)
    print(str(w.values())[12:-1].replace("'", '"').replace(" ", ""), file=f)
exit()
'''
'''
from collections import defaultdict
from typing import List

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = defaultdict(list)
        
        for word in strs:
            # Sort the word to create the key
            sorted_word = ''.join(sorted(word))
            # Append the word to the corresponding anagram group
            anagrams[sorted_word].append(word)
        
        # Return all the anagram groups
        return list(anagrams.values())     
'''