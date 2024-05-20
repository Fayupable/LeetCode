class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0) {
            return 1/x * myPow(1/x, -(n+1));
        }
        double result=1;
        while(n > 0){
            if(n % 2 == 1){
                result *= x;
                --n;
            }
            x *= x;
            n /= 2;
        }
        return result;
    }

        
        
    }
