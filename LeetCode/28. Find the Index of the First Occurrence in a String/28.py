class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        # Use the find method of the string class to find the first occurrence of needle in haystack
        # If needle is found, this method returns the index of the first character of the first occurrence of needle
        # If needle is not found, it returns -1
        return haystack.find(needle)