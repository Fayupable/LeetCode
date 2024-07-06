class Solution {
    public int passThePillow(int n, int time) {
        int curr = time / (n - 1);
        return curr % 2 == 0 ? (time % (n - 1) + 1) : (n - time % (n - 1));
    }
}

/*
 class Solution {
    public int passThePillow(int n, int time) {
        int div = n - 1;
        
        int afterDividing = time / div;
        
        int offset = div * afterDividing;
        
        if(afterDividing % 2 == 0) {
            return 1 + (time - offset);
        } else {
            return n - (time - offset);
        }
    }
}
 */

 //better memory management
 /*
  class Solution {
    public int passThePillow(int n, int time) {
        // represents the number of complete rounds of pillow passing
        int fullRounds = time / (n - 1);

        // represents the remaining time after the complete rounds
        int extraTime = time % (n - 1);

        // If the number of complete rounds is even, the pillow is moving
        // forward. So, the person holding the pillow is at position
        // 'extraTime + 1' since we start from 1.
        // If the number of complete rounds is odd, the pillow is moving
        // backward. So, the person holding the pillow is at position
        // 'n - extraTime'
        return fullRounds % 2 == 0 ? extraTime + 1 : n - extraTime;
    }
}
  */