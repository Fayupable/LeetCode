#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>

using namespace std;

class Solution {
public:
    // Helper function to calculate the score of a word
    int wordScore(const string& word, const vector<int>& score) {
        int wordScore = 0;
        for (char c : word) {
            wordScore += score[c - 'a'];
        }
        return wordScore;
    }

    // Backtracking function to find the maximum score
    int backtrack(int index, int currentScore, vector<int>& remainingLetters, const vector<string>& words, const vector<int>& score) {
        if (index == words.size()) {
            return currentScore;
        }

        // Option 1: Skip the current word
        int maxScore = backtrack(index + 1, currentScore, remainingLetters, words, score);

        // Option 2: Include the current word if possible
        string word = words[index];
        vector<int> wordCount(26, 0);
        for (char c : word) {
            wordCount[c - 'a']++;
        }

        bool canUseWord = true;
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
            maxScore = max(maxScore, backtrack(index + 1, currentScore + wordScore(word, score), remainingLetters, words, score));
            for (int i = 0; i < 26; i++) {
                remainingLetters[i] += wordCount[i];
            }
        }

        return maxScore;
    }

    int maxScoreWords(vector<string>& words, vector<char>& letters, vector<int>& score) {
        // Initial call to the backtracking function
        vector<int> letterCount(26, 0);
        for (char c : letters) {
            letterCount[c - 'a']++;
        }
        return backtrack(0, 0, letterCount, words, score);
    }
};

// Example usage
int main() {
    Solution solution;
    
    vector<string> words1 = {"dog", "cat", "dad", "good"};
    vector<char> letters1 = {'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'};
    vector<int> score1 = {1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    vector<string> words2 = {"xxxz", "ax", "bx", "cx"};
    vector<char> letters2 = {'z', 'a', 'b', 'c', 'x', 'x', 'x'};
    vector<int> score2 = {4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10};

    vector<string> words3 = {"leetcode"};
    vector<char> letters3 = {'l', 'e', 't', 'c', 'o', 'd'};
    vector<int> score3 = {0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0};

    cout << solution.maxScoreWords(words1, letters1, score1) << endl;  // Output: 23
    cout << solution.maxScoreWords(words2, letters2, score2) << endl;  // Output: 27
    cout << solution.maxScoreWords(words3, letters3, score3) << endl;  // Output: 0

    return 0;
}
