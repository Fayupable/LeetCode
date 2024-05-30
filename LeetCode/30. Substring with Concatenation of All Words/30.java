class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) return result;

        int wordLength = words[0].length();
        int wordCount = words.length;
        int windowLength = wordLength * wordCount;
        
        if (windowLength > s.length()) return result;

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Check each possible starting point
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            Map<String, Integer> currentMap = new HashMap<>();
            int count = 0;
            for (int j = i; j <= s.length() - wordLength; j += wordLength) {
                String currentWord = s.substring(j, j + wordLength);
                
                // If it is a valid word
                if (wordMap.containsKey(currentWord)) {
                    currentMap.put(currentWord, currentMap.getOrDefault(currentWord, 0) + 1);
                    count++;
                    
                    // If there are too many occurrences of a word, slide the window
                    while (currentMap.get(currentWord) > wordMap.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }
                    
                    // If the window is valid
                    if (count == wordCount) {
                        result.add(left);
                        // Slide the window to try for the next possible solution
                        String leftWord = s.substring(left, left + wordLength);
                        currentMap.put(leftWord, currentMap.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }
                } else {
                    // If currentWord is not a valid word
                    currentMap.clear();
                    count = 0;
                    left = j + wordLength;
                }
            }
        }
        
        return result;
    }
}