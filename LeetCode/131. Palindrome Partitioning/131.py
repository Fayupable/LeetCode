class Solution(object):
    def partition(self, s):
        """
        :type s: str
        :rtype: List[List[str]]
        """
        def is_palindrome(s):
            return s == s[::-1]

        def dfs(s, path, res):
            if not s:
                res.append(path)
                return
            for i in range(1, len(s) + 1):
                if is_palindrome(s[:i]):
                    dfs(s[i:], path + [s[:i]], res)

        res = []
        dfs(s, [], res)
        return res