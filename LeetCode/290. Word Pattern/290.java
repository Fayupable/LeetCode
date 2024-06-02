class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" "); // Split the string s into words
        if (pattern.length() != words.length) { // If the length of the pattern is not equal to the number of words, return false
            return false;
        }
        Map<Character, String> map = new HashMap<>(); // Create a map to store the mapping from characters to words
        Set<String> set = new HashSet<>(); // Create a set to store the unique words
        for (int i = 0; i < pattern.length(); i++) { // Iterate over the characters in the pattern
            char c = pattern.charAt(i); // Get the current character
            if (map.containsKey(c)) { // If the map contains the current character
                if (!map.get(c).equals(words[i])) { // If the word mapped to the current character is not equal to the current word, return false
                    return false;
                }
            } else { // If the map does not contain the current character
                if (set.contains(words[i])) { // If the set contains the current word, return false
                    return false;
                }
                map.put(c, words[i]); // Add the current character and word to the map
                set.add(words[i]); // Add the current word to the set
            }
        }
        return true; // If all characters and words match, return true
    }
}
/*
 class Solution {
    public boolean wordPattern(String pattern, String s) {

        
        HashMap<Character, String> map = new HashMap<>();
        String[] word = s.split(" ");

        if (pattern.length() != word.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (!map.containsKey(pattern.charAt(i))) {

                if (map.containsValue(word[i])) {
                    return false;
                }

                map.put(pattern.charAt(i), word[i]);
            } else {
                if (!map.get(pattern.charAt(i)).equals(word[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
 */

 