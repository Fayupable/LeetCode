class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalBottle = numBottles;
        int emptyBottle = numBottles;
        // while we can exchange the empty bottle
        while(emptyBottle >= numExchange){
            int newBottle = emptyBottle / numExchange;
            totalBottle += newBottle;
            // update the empty bottle
            emptyBottle = newBottle + (emptyBottle % numExchange);
        }
        return totalBottle;

        
    }
}