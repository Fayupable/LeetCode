class Solution {
public:
    double myPow(double x, int n) {
        //Have an if, else to catch positive or negative n
        //square x
        long long N = n;
        if(N < 0){
            x = 1/x;
            N = -N;
        }

        double result = 1.0;
        double current_product = x;

        while(N > 0){
            if (N%2 == 1){
                result *= current_product;
            }
            current_product *= current_product;
            N /= 2;
        }
        return result;
    }
};