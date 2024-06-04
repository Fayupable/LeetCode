class Solution(object):
    # Define a class named Solution

    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        # Define a method named longestPalindrome that takes a string s as input

        count = {}
        # Initialize an empty dictionary count to store the frequency of each character in s

        for c in s:
            count[c] = count.get(c, 0) + 1
        # Iterate over each character c in s, incrementing its count in the count dictionary

        length = 0
        # Initialize a variable length to 0. This variable will store the length of the longest palindrome that can be built with the characters of s

        for v in count.values():
            length += v // 2 * 2
            # For each value v in the count dictionary, add the largest even number less than or equal to v to length

            if length % 2 == 0 and v % 2 == 1:
                length += 1
        # If length is even and v is odd, increment length by 1. This accounts for the fact that a palindrome can have one character that appears an odd number of times in the middle

        return length
        # Return the length of the longest palindrome that can be built with the characters of s

#other people's solution
'''
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        lookup = Counter([char for char in s])
        pal_len= 0
        odd = False
        for char,value in lookup.items():
            if not odd and value%2 != 0:
                pal_len +=value
                print("odd{}",format(value))
                odd = True
            else:
                pal_len += int(value/2)*2
        return pal_len  
        
'''
'''
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
       
        # dic = {}
        # for char in s:
        #     dic[char] = dic.get(char, 0) + 1
        
        # counts = dic.values()
    
        # odd_flag = 0
        # res = 0
        # for x in counts:
        #     if x % 2 == 0:
        #         res += x
        #     else:
        #         res += x - 1
        #         odd_flag = 1
        # return res + odd_flag

        ss = set()
        for char in s:
            if char not in ss:
                ss.add(char)
            else:
                ss.remove(char)
        
        if len(ss) > 0:
            return len(s) - len(ss) + 1
        
        return len(s)
'''
'''
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s)==1:
            return 1
        
        char_count = {}

        for letter in s:
            if letter in char_count:
                char_count[letter]+=1
            else:
                char_count[letter]=1
        odd_sum = 0
        has_odd = False
        sum_even = 0
        for num in char_count.values():
            if num%2==1:
                odd_sum+=num-1
                has_odd=True
            else:
                sum_even+=num
        if has_odd:
            return odd_sum+sum_even+1
        return sum_even
'''
'''
class Solution(object):
    def longestPalindrome(self, s):
        setA = set()
        for char in s:
            if char not in setA:
                setA.update(char)
            else:
                setA.remove(char)
        
        if len(setA) != 0:
            return len(s) - len(setA) + 1
        else:
            return len(s)
'''