class Solution(object):
    def commonChars(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        # Initialize a list with the count of each character in the first word
        counts = [min(word.count(char) for word in words) for char in set(words[0])]
        
        # For each word, update the count list with the minimum count of each character in all words seen so far
        for word in words[1:]:
            counts = [min(count, word.count(char)) for count, char in zip(counts, set(words[0]))]
        
        # Return a list of characters that appear in all words, with each character repeated the number of times it appears in all words
        return [char for count, char in zip(counts, set(words[0])) for _ in range(count)]
    
    '''
    class Solution(object):
    def commonChars(self, words):
        """
        :type words: List[str]
        :rtype: List[str]
        """
        res = []
        for c in set(words[0]):
            count = min([word.count(c) for word in words])
            res += [c] * count
        return res
        
    '''