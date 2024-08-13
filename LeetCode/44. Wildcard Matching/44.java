class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];

        initializeDP(dp, p);

        fillDP(dp, s, p);

        return dp[m][n];
    }

    private void initializeDP(boolean[][] dp, String p) {
        int n = p.length();

        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
    }

    private void fillDP(boolean[][] dp, String s, String p) {
        int m = s.length();
        int n = p.length();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
    }
}
//other peoples solution
/*
 * class Solution {
 * public boolean isMatch(String s, String p) {
 * int sIndex = 0, pIndex = 0, matchIndex = 0, starIndex = -1;
 * 
 * while (sIndex < s.length()) {
 * if (pIndex < p.length() && (s.charAt(sIndex) == p.charAt(pIndex) ||
 * p.charAt(pIndex) == '?')) {
 * sIndex++;
 * pIndex++;
 * } else if (pIndex < p.length() && p.charAt(pIndex) == '*') {
 * starIndex = pIndex;
 * matchIndex = sIndex;
 * pIndex++;
 * } else if (starIndex != -1) {
 * pIndex = starIndex + 1;
 * matchIndex++;
 * sIndex = matchIndex;
 * } else {
 * return false;
 * }
 * }
 * 
 * while (pIndex < p.length() && p.charAt(pIndex) == '*') {
 * pIndex++;
 * }
 * 
 * return pIndex == p.length();
 * }
 * }
 */