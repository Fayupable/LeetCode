class Solution {
    private int[][] dp;

    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        
        int n = s.length();
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        
        return findCommon(0, 0, s, reversed);
    }

    public int findCommon(int index1, int index2, String word1, String word2) {
        if (index1 >= word1.length() || index2 >= word2.length()) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (word1.charAt(index1) == word2.charAt(index2)) {
            return dp[index1][index2] = 1 + findCommon(index1 + 1, index2 + 1, word1, word2);
        }

        return dp[index1][index2] = Math.max(
            findCommon(index1, index2 + 1, word1, word2),
            findCommon(index1 + 1, index2, word1, word2)
        );
    }
}