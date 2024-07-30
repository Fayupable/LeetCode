class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        int b = 0;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) == 'b') {
                f[i] = f[i - 1];
                ++b;
            } else {
                f[i] = Math.min(f[i - 1] + 1, b);
            }
        }
        return f[n];
    }
}

/*
 * class Solution {
 * public int minimumDeletions(String s) {
 * char[] letters = s.toCharArray();
 * int aCount = 0;
 * int bCount = 0;
 * int output = Integer.MAX_VALUE;
 * for (int i = 0; i < letters.length; i++)
 * aCount += ('b' - letters[i]);
 * 
 * for (int i = 0; i < s.length(); i++)
 * {
 * output = Math.min(output, aCount + bCount);
 * aCount -= ('b' - letters[i]);
 * bCount += (letters[i] - 'a');
 * }
 * 
 * output = Math.min(output, aCount + bCount);
 * return output;
 * }
 * }
 */