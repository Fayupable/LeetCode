class Solution {
    public int longestValidParentheses(String s) {
        return Math.max(scanFromLeftToRight(s), scanFromRightToLeft(s));
    }
    
    // Function to scan from left to right
    private int scanFromLeftToRight(String s) {
        int maxLen = 0, left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }
        return maxLen;
    }

    // Function to scan from right to left
    private int scanFromRightToLeft(String s) {
        int maxLen = 0, left = 0, right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }
        return maxLen;
    }
}