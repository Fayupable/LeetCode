from collections import Counter

class Solution(object):
    def maxScoreWords(self, words, letters, score):
        """
        :type words: List[str]
        :type letters: List[str]
        :type score: List[int]
        :rtype: int
        """
        # Helper function to calculate the score of a word
        def word_score(word):
            return sum(score[ord(char) - ord('a')] for char in word)
        
        # Backtracking function to find the maximum score
        def backtrack(index, current_score, remaining_letters):
            if index == len(words):
                return current_score
            
            # Option 1: Skip the current word
            max_score = backtrack(index + 1, current_score, remaining_letters)
            
            # Option 2: Include the current word if possible
            word = words[index]
            word_count = Counter(word)
            if all(remaining_letters[char] >= word_count[char] for char in word_count):
                new_remaining_letters = remaining_letters - word_count
                max_score = max(max_score, backtrack(index + 1, current_score + word_score(word), new_remaining_letters))
            
            return max_score
        
        # Initial call to the backtracking function
        letter_count = Counter(letters)
        return backtrack(0, 0, letter_count)


