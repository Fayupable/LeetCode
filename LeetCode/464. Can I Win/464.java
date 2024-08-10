class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (desiredTotal <= 0) return true;
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal) return false;
        

        Boolean[] memo = new Boolean[1 << maxChoosableInteger];
        return canWin(maxChoosableInteger, desiredTotal, 0, memo);
    }
    
    private boolean canWin(int maxChoosableInteger, int desiredTotal, int usedNumbers, Boolean[] memo) {
        if (memo[usedNumbers] != null) return memo[usedNumbers];
        
        for (int i = 0; i < maxChoosableInteger; i++) {
            int current = (1 << i);
            if ((usedNumbers & current) == 0) { 
                if (desiredTotal <= i + 1 || 
                    !canWin(maxChoosableInteger, desiredTotal - (i + 1), usedNumbers | current, memo)) {
                    memo[usedNumbers] = true;
                    return true;
                }
            }
        }
        
        memo[usedNumbers] = false;
        return false;
    }
}