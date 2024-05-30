class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean numberSeen = false;
        boolean eSeen = false;
        boolean numberAfterE = true;
        boolean pointSeen = false;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if('0' <= c && c <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if(c == '.') {
                if(eSeen || pointSeen) {
                    return false;
                }
                pointSeen = true;
            } else if(c == 'e' || c == 'E') {
                if(eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if(c == '+' || c == '-') {
                if(i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        
        return numberSeen && numberAfterE;
    }
}
