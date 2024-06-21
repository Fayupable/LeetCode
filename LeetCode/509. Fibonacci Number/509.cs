public class Solution {
    public int Fib(int n) {
        int fib = 0;
        int a =1;

        for (int i = 0; i < n; i++)
        {
            int temp = fib+a;
            fib = a;
            a = temp;    
        }
        return fib;
        
    }
}