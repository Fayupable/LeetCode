class Solution {
public:
    int addDigits(int num) {
        
        if(num == 0) return 0;
        
        int result = num % 9;
        
        if(result == 0) return 9;
        
        return result;
    }
};

/*
class Solution {
public:
    int addDigits(int num) {
        int x = 0;
        while(num>=10){
            x = 0;
            while(num){
                x += (num%10);
                num /= 10;
            }
            num = x;
        }
        return num;
    }
};
*/