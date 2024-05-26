class Solution {
    public int checkRecord(int n) {
        int mod = 1000000007;
        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int A = 0; A < 2; A++) {
                for (int L = 0; L < 3; L++) {
                    // Add 'P'
                    dp[i][A][0] = (dp[i][A][0] + dp[i - 1][A][L]) % mod;

                    // Add 'A'
                    if (A > 0) {
                        dp[i][A][0] = (dp[i][A][0] + dp[i - 1][A - 1][L]) % mod;
                    }

                    // Add 'L'
                    if (L > 0) {
                        dp[i][A][L] = (dp[i][A][L] + dp[i - 1][A][L - 1]) % mod;
                    }
                }
            }
        }

        int result = 0;
        for (int A = 0; A < 2; A++) {
            for (int L = 0; L < 3; L++) {
                result = (result + dp[n][A][L]) % mod;
            }
        }

        return result;
    }
}


/*
 class Solution {
    static final int M = 1000000007;

public int checkRecord(int n) {
    long[] PorL = new long[n + 1]; // ending with P or L, no A
    long[] P = new long[n + 1]; // ending with P, no A
    PorL[0] = P[0] = 1; PorL[1] = 2; P[1] = 1;

    for (int i = 2; i <= n; i++) {
        P[i] = PorL[i - 1];
        PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
    }
    
    long res = PorL[n];
    for (int i = 0; i < n; i++) { // inserting A into (n-1)-length strings
    	long s = (PorL[i] * PorL[n - i - 1]) % M;
        res = (res + s) % M;
    }
    
    return (int) res;
}
}
 */