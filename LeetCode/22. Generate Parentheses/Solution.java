public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        backtrack(combinations, new StringBuilder(), 0, 0, n);
        return combinations;
    }
    
    private void backtrack(List<String> combinations, StringBuilder current, int open, int close, int max) {
        if (current.length() == max * 2) {
            combinations.add(current.toString());
            return;
        }

        if (open < max) {
            current.append("(");
            backtrack(combinations, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1);
        }
        
        if (close < open) {
            current.append(")");
            backtrack(combinations, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
