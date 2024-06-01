class Solution(object):
    def scoreOfString(self, s):
        """
        :type s: str
        :rtype: int
        """
        score = 0  # Initialize a variable to keep track of the score. The initial value is 0.
        for i in range(1, len(s)):  # Loop through all characters of the string, starting from the second character
            score += abs(ord(s[i]) - ord(s[i - 1]))  # Subtract the ASCII value of the previous character from the ASCII value of the current character, take the absolute value of this subtraction, and add it to the total score.
        return score  # Return the total score.

'''
class Solution(object):
    def scoreOfString(self, s):
        """
        :type s: str
        :rtype: int
        """
        x = 0
        for i in range(1,len(s)):
            x+= abs(ord(s[i-1])-ord(s[i]))
        return x
'''

'''
class Solution(object):
    def scoreOfString(self, s):
        """
        :type s: str
        :rtype: int
        """
        temp = ord(s[0])
        count = 0
        for i in s:
            a = ord(i)
            count += abs(temp-a)
            temp = a
        return count
'''