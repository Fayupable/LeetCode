class Solution(object):
    def truncateSentence(self, s, k):
        """
        :type s: str
        :type k: int
        :rtype: str
        """
        words=s.split()
        trucanted=' '.join(words[:k])
        return trucanted
    