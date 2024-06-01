class Solution {
    public int scoreOfString(String s) {
        // Initialize a variable to keep track of the score. The initial value is 0.
        int score = 0;

        // Loop through all characters of the string. We start from the second character because we will compare it with the previous character.
        for (int i = 1; i < s.length(); i++) {
            // Subtract the ASCII value of the previous character from the ASCII value of the current character.
            // We take the absolute value of this subtraction to avoid negative results.
            // We add this value to the total score.
            score += Math.abs(s.charAt(i) - s.charAt(i - 1));
        }

        // Return the total score.
        return score;
    }
}

/*
 class Solution {
    public int scoreOfString(String s) {
        return iterateString(0,s);   
    }

    public static int iterateString(int n, String s){
        if(n == s.length() -1 )
            return 0;
        return Math.abs(s.charAt(n) - s.charAt(n+1)) + iterateString(n+1, s);
    }
}
 */