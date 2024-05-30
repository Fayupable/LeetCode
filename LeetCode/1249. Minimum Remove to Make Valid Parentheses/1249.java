class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        int balance = 0; // Tracks the balance of parentheses.
        int openSeen = 0; // Tracks the number of '(' seen that are not yet matched.
        
        // First pass: remove unmatched ')'
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                balance++;
                openSeen++;
            } else if (c == ')') {
                if (balance == 0) { // This ')' is unmatched, remove it.
                    sb.deleteCharAt(i);
                    i--; // Adjust the index since we just removed a character.
                } else {
                    balance--;
                }
            }
        }
        
        // Second pass: remove unmatched '(' from the end
        int openToKeep = openSeen - balance; // The number of '(' to keep is the total seen minus the unmatched ones.
        for (int i = sb.length() - 1; i >= 0 && openToKeep < openSeen; i--) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                openSeen--;
            }
        }
        
        return sb.toString();
    }
}
