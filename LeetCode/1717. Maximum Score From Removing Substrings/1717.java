class Solution {
    public int maximumGain(String s, int x, int y) {
        // Determine the order of removal based on the values of x and y
        String first = x > y ? "ab" : "ba";
        int firstValue = Math.max(x, y);
        String second = x > y ? "ba" : "ab";
        int secondValue = Math.min(x, y);

        // Remove the first substring and calculate the score
        int score = removeAndScore(s, first, firstValue);

        // Directly use the result from the first removal as input for the second
        // removal
        String remainingString = removeAndReturnRemaining(s, first);

        // Remove the second substring from the remaining string and update the score
        score += removeAndScore(remainingString, second, secondValue);

        return score;
    }

    private int removeAndScore(String s, String target, int value) {
        int score = 0;
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            int currentSize = stack.length();
            if (currentSize > 0 && stack.charAt(currentSize - 1) == target.charAt(0) && c == target.charAt(1)) {
                // Found a target substring, remove the last character and add to score
                stack.deleteCharAt(currentSize - 1);
                score += value;
            } else {
                // Push the current character onto the stack
                stack.append(c);
            }
        }
        // Update the input string for the next removal
        s = stack.toString();
        return score;
    }

    // New method to remove the first substring and return the remaining string
    private String removeAndReturnRemaining(String s, String target) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            int currentSize = stack.length();
            if (currentSize > 0 && stack.charAt(currentSize - 1) == target.charAt(0) && c == target.charAt(1)) {
                // Found a target substring, remove the last character
                stack.deleteCharAt(currentSize - 1);
            } else {
                // Push the current character onto the stack
                stack.append(c);
            }
        }
        return stack.toString();
    }
}

/*
 * class Solution {
 * 
 * public int maximumGain(String s, int x, int y) {
 * // Ensure "ab" always has higher points than "ba"
 * if (x < y) {
 * // Swap points
 * int temp = x;
 * x = y;
 * y = temp;
 * // Reverse the string to maintain logic
 * s = new StringBuilder(s).reverse().toString();
 * }
 * 
 * int aCount = 0, bCount = 0, totalPoints = 0;
 * 
 * for (int i = 0; i < s.length(); i++) {
 * char currentChar = s.charAt(i);
 * 
 * if (currentChar == 'a') {
 * aCount++;
 * } else if (currentChar == 'b') {
 * if (aCount > 0) {
 * // Can form "ab", remove it and add points
 * aCount--;
 * totalPoints += x;
 * } else {
 * // Can't form "ab", keep 'b' for potential future 'ba'
 * bCount++;
 * }
 * } else {
 * // Non 'a' or 'b' character encountered
 * // Calculate points for any remaining 'ba' pairs
 * totalPoints += Math.min(bCount, aCount) * y;
 * // Reset counters for next segment
 * aCount = bCount = 0;
 * }
 * }
 * 
 * // Calculate points for any remaining "ba" pairs at the end
 * totalPoints += Math.min(bCount, aCount) * y;
 * 
 * return totalPoints;
 * }
 * }
 */

/*
 * class Solution {
 * public int maximumGain(String s, int x, int y) {
 * 
 * int aCount = 0;
 * int bCount = 0;
 * int lesser = Math.min(x, y);
 * int result = 0;
 * 
 * for (int i = 0; i < s.length(); i++) {
 * char c = s.charAt(i);
 * if (c > 'b') {
 * result += Math.min(aCount, bCount) * lesser;
 * aCount = 0;
 * bCount = 0;
 * } else if (c == 'a') {
 * if (x < y && bCount > 0) {
 * bCount--;
 * result += y;
 * } else {
 * aCount++;
 * }
 * } else {
 * if (x > y && aCount > 0) {
 * aCount--;
 * result += x;
 * } else {
 * bCount++;
 * };
 * }
 * }
 * 
 * result += Math.min(aCount, bCount) * lesser;
 * 
 * return result;
 * }
 * }
 */