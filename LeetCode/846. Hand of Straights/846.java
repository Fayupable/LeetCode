class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        // Define a method named isNStraightHand that takes an integer array hand and an integer groupSize as input
        // This method will return true if the cards in hand can be rearranged into groups of groupSize consecutive cards, and false otherwise

        if (hand.length % groupSize != 0) {
            return false;
        }
        // If the number of cards in hand is not a multiple of groupSize, return false

        TreeMap<Integer, Integer> map = new TreeMap<>();
        // Initialize a TreeMap map to store the frequency of each card in hand

        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        // Count the frequency of each card in hand

        while (map.size() > 0) {
            // While there are cards left in hand

            int first = map.firstKey();
            // Get the smallest card in hand

            for (int i = first; i < first + groupSize; i++) {
                // For each card in the group starting from the smallest card

                if (!map.containsKey(i)) {
                    return false;
                }
                // If the current card is not in hand, return false

                int count = map.get(i);
                // Get the frequency of the current card in hand

                if (count == 1) {
                    map.remove(i);
                } else {
                    map.put(i, count - 1);
                }
                // If the current card is in hand only once, remove it from hand
                // Otherwise, decrease its frequency by 1
            }
        }

        return true;
        // If all cards in hand can be rearranged into groups of groupSize consecutive cards, return true
    }
}
//other people's solution
/*
 class Solution {
    public boolean findsucessors(int[] hand, int groupSize, int i, int n) {
        int f = hand[i] + 1;
        hand[i] = -1;
        int count = 1;
        i += 1;
        while (i < n && count < groupSize) {
            if (hand[i] == f) {
                f = hand[i] + 1;
                hand[i] = -1;
                count++;
            }
            i++;
        }
        if (count != groupSize)
            return false;
        else
            return true;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0)
            return false;
        Arrays.sort(hand);
        int i = 0;
        for (; i < n; i++) {
            if (hand[i] >= 0) {
                if (!findsucessors(hand, groupSize, i, n))
                    return false;
            }
        }
        return true;
    }
}
 */
/*
 class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }
        int[] handCopy = new int[hand.length];
        System.arraycopy(hand, 0, handCopy, 0, handCopy.length);
        Arrays.sort(handCopy);
        for(int i = 0; i < handCopy.length; i++) {
            if(handCopy[i] == -1) {
                continue;
            }
            int last = handCopy[i];
            int count = 1;
            for(int j = i + 1; j < handCopy.length && count < groupSize; j++) {
                if(handCopy[j] == last || handCopy[j] == -1) {
                    continue;
                }
                if(handCopy[j] - last == 1) {
                    last = handCopy[j];
                    handCopy[j] = -1;
                    count++;
                } else {
                    break;
                }
                
            }
            if(count != groupSize) {
                return false;
            }
        }
        return true;
    }
}
 */
/*
 class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
        int n = hand.length;
         Arrays.sort(hand);
      
        if(n % groupSize != 0)return false;

        int size = n/ groupSize;
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        Stack<Integer> st =new Stack<>();
        int prev = -1;

       
        for(int x: hand){
            ad.offerLast(x);
        }
        int count = 0;
        int group = 0;
        while(ad.size() > 0){
            int val = ad.pollFirst();
            if(prev == -1){
                count++;
                prev = val;
            }else if(prev != -1 && prev == val-1){
                count++;
                prev = val;
            }else{
                while(ad.size() > 0 && prev != val-1){
                    st.push(val);
                    val = ad.pollFirst();
                }
                if(ad.size() == 0)
                    return false;
                count++;
                prev = val;
               
            }

            if(count == groupSize){
                count = 0;
                prev = -1;
                group++;
                 while(st.size() > 0){
                    ad.offerFirst(st.pop());
                }
            }
        }
        // if(prev ==-1 )return true;
        if(group == size)return true;
        return false;
        // return true;
    }
}
 */