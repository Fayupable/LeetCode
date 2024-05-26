class Solution(object):
    def checkRecord(self, n):
        """
        :type n: int
        :rtype: int
        """
        mod = 1000000007
        dp = [[[0] * 3 for _ in range(2)] for _ in range(n + 1)]
        dp[0][0][0] = 1

        for i in range(1, n + 1):
            for A in range(2):
                for L in range(3):
                    # Add 'P'
                    dp[i][A][0] = (dp[i][A][0] + dp[i - 1][A][L]) % mod

                    # Add 'A'
                    if A > 0:
                        dp[i][A][0] = (dp[i][A][0] + dp[i - 1][A - 1][L]) % mod

                    # Add 'L'
                    if L > 0:
                        dp[i][A][L] = (dp[i][A][L] + dp[i - 1][A][L - 1]) % mod

        result = 0
        for A in range(2):
            for L in range(3):
                result = (result + dp[n][A][L]) % mod

        return result
    



    '''
    class Solution(object):
    def checkRecord(self, n):
        """
        :type n: int
        :rtype: int
        """
        M = (10 ** 9) + 7
        l0a0 = 1
        l1a0 = 0
        l2a0 = 0
        l0a1 = 0
        l1a1 = 0
        l2a1 = 0

        for _ in range(n):
            l0a0, l0a1, l1a0, l2a0,  l1a1, l2a1 = (l0a0 + l1a0 + l2a0) % M,  (l0a1 + l1a1 + l2a1 + l0a0 + l1a0 + l2a0) % M, l0a0, l1a0, l0a1, l1a1
         
        return (l0a0 + l1a0 + l2a0 + l0a1 + l1a1 + l2a1) % M
    '''