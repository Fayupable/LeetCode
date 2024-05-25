#include <vector>
#include <string>
#include <unordered_set>
#include <unordered_map>
#include <sstream>

using namespace std;

class Solution {
public:
    vector<string> wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> dict(wordDict.begin(), wordDict.end());
        unordered_map<int, vector<string>> memo;
        return backtrack(s, dict, 0, memo);
    }

private:
    vector<string> backtrack(const string& s, const unordered_set<string>& dict, int start, unordered_map<int, vector<string>>& memo) {
        if (start == s.size()) {
            return {""};
        }

        if (memo.find(start) != memo.end()) {
            return memo[start];
        }

        vector<string> sentences;
        for (int end = start + 1; end <= s.size(); end++) {
            string word = s.substr(start, end - start);
            if (dict.find(word) != dict.end()) {
                vector<string> subsentences = backtrack(s, dict, end, memo);
                for (const string& subsentence : subsentences) {
                    sentences.push_back(word + (subsentence.empty() ? "" : " " + subsentence));
                }
            }
        }
        memo[start] = sentences;
        return sentences;
    }
};
