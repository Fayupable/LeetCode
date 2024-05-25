class Solution:
    def wordBreak(self, s, wordDict):
        from collections import defaultdict

        def backtrack(start):
            if start == len(s):
                return [""]

            if start in memo:
                return memo[start]

            sentences = []
            for end in range(start + 1, len(s) + 1):
                word = s[start:end]
                if word in wordDict:
                    for subsentence in backtrack(end):
                        if subsentence:
                            sentences.append(word + " " + subsentence)
                        else:
                            sentences.append(word)
            memo[start] = sentences
            return sentences

        wordDict = set(wordDict)
        memo = defaultdict(list)
        return backtrack(0)
