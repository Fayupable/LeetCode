class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String rev_s = new StringBuilder(s).reverse().toString();

        String combined = s + "#" + rev_s;

        int[] lps = computeLPSArray(combined);

        int longestPalindromePrefixLength = lps[combined.length() - 1];

        String suffix = s.substring(longestPalindromePrefixLength);

        StringBuilder shortestPalindrome = new StringBuilder();
        shortestPalindrome.append(new StringBuilder(suffix).reverse());
        shortestPalindrome.append(s);

        return shortestPalindrome.toString();
    }

  
    private int[] computeLPSArray(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        lps[0] = 0; 

        int len = 0; 

        for (int i = 1; i < n; i++) {
            while (len > 0 && pattern.charAt(len) != pattern.charAt(i)) {
                len = lps[len - 1];
            }

            if (pattern.charAt(len) == pattern.charAt(i)) {
                len++;
            }

            lps[i] = len;
        }

        return lps;
    }
}