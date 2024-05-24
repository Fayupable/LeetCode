class Solution {
    // Helper function to calculate the score of a word
    private int wordScore(String word, int[] score) {
        int wordScore = 0;
        for (char c : word.toCharArray()) {
            wordScore += score[c - 'a'];
        }
        return wordScore;
    }

    // Backtracking function to find the maximum score
    private int backtrack(int index, int currentScore, int[] remainingLetters, String[] words, int[] score) {
        if (index == words.length) {
            return currentScore;
        }

        // Option 1: Skip the current word
        int maxScore = backtrack(index + 1, currentScore, remainingLetters, words, score);

        // Option 2: Include the current word if possible
        String word = words[index];
        int[] wordCount = new int[26];
        for (char c : word.toCharArray()) {
            wordCount[c - 'a']++;
        }

        boolean canUseWord = true;
        for (int i = 0; i < 26; i++) {
            if (wordCount[i] > remainingLetters[i]) {
                canUseWord = false;
                break;
            }
        }

        if (canUseWord) {
            for (int i = 0; i < 26; i++) {
                remainingLetters[i] -= wordCount[i];
            }
            maxScore = Math.max(maxScore, backtrack(index + 1, currentScore + wordScore(word, score), remainingLetters, words, score));
            for (int i = 0; i < 26; i++) {
                remainingLetters[i] += wordCount[i];
            }
        }

        return maxScore;
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // Initial call to the backtracking function
        int[] letterCount = new int[26];
        for (char c : letters) {
            letterCount[c - 'a']++;
        }
        return backtrack(0, 0, letterCount, words, score);
    }
}