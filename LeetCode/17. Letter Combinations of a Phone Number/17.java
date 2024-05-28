class Solution {
    private static final Map<Character, String> phoneMap = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        
        List<String> combinations = new ArrayList<>();
        backtrack(combinations, new StringBuilder(), digits, 0);
        return combinations;
    }

    private void backtrack(List<String> combinations, StringBuilder current, String digits, int index) {
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        String letters = phoneMap.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(combinations, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }

   
}
