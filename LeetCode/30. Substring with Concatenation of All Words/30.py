class Solution(object):
    def findSubstring(self, s, words):
        from collections import defaultdict
        
        if not s or not words:
            return []
        
        word_len = len(words[0])
        word_count = len(words)
        total_len = word_len * word_count
        word_map = defaultdict(int)
        for word in words:
            word_map[word] += 1
        
        results = []
        
        for i in range(word_len):
            left = i
            current_map = defaultdict(int)
            count = 0
            # Move right in steps of word_len
            for j in range(i, len(s) - word_len + 1, word_len):
                current_word = s[j:j + word_len]
                # Check if it is a valid word
                if current_word in word_map:
                    current_map[current_word] += 1
                    count += 1
                    
                    # If too many of one word, adjust from the left
                    while current_map[current_word] > word_map[current_word]:
                        left_word = s[left:left + word_len]
                        current_map[left_word] -= 1
                        count -= 1
                        left += word_len
                    
                    # If we have all the words in the correct counts
                    if count == word_count:
                        results.append(left)
                        left_word = s[left:left + word_len]
                        current_map[left_word] -= 1
                        count -= 1
                        left += word_len
                else:
                    # Reset if the word isn't in the dictionary
                    current_map.clear()
                    count = 0
                    left = j + word_len
        
        return results
