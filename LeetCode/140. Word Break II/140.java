import java.util.*;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return backtrack(s, new HashSet<>(wordDict), 0, new HashMap<>());
    }

    private List<String> backtrack(String s, Set<String> wordDict, int start, Map<Integer, List<String>> memo) {
        if (start == s.length()) {
            return Arrays.asList("");
        }

        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> sentences = new ArrayList<>();
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (wordDict.contains(word)) {
                List<String> subsentences = backtrack(s, wordDict, end, memo);
                for (String subsentence : subsentences) {
                    sentences.add(word + (subsentence.isEmpty() ? "" : " " + subsentence));
                }
            }
        }
        memo.put(start, sentences);
        return sentences;
    }
}
