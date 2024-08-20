class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int[] suffixSum = new int[n];
        
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }
        
        return helper(piles, dp, suffixSum, 0, 1);
    }
    
    private int helper(int[] piles, int[][] dp, int[] suffixSum, int i, int M) {
        int n = piles.length;
        
        if (i >= n) {
            return 0;
        }
        
        if (dp[i][M] != 0) {
            return dp[i][M];
        }
        
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }
        
        int maxStones = 0;
        for (int X = 1; X <= 2 * M; X++) {
            maxStones = Math.max(maxStones, suffixSum[i] - helper(piles, dp, suffixSum, i + X, Math.max(M, X)));
        }
        
        dp[i][M] = maxStones;
        return dp[i][M];
    }
}