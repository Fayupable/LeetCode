class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int totalBottle= numBottles;

        while (numBottles>=numExchange)
        {
            totalBottle += numBottles/numExchange;
            numBottles= (numBottles%numExchange) + (numBottles/numExchange);
            
        }
        return totalBottle;
        
    }
};

//Another solution

//faster solution
/*
class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        int sum=numBottles;
        int x=numBottles;
        while(true){
            int y=x/numExchange;
            int z=x%numExchange;
            sum+=y;
            x=y+z;
            if(x<numExchange){
                break;
            }
        }
        return sum;
    }
};
*/

//better memory usage
/*
class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
         int ans = 0; // Initialize ans with the initial number of bottles
        int empty = 0;
        while (numBottles > 0) {
            ans += numBottles;
            empty += numBottles;
            numBottles = empty / numExchange;
            empty %= numExchange;
        }
        return ans;
        
    }
};
*/