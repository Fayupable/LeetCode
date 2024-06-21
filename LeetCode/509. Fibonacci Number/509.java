class Solution {
    public int fib(int n) {
        int fib =0;
        int a=1;
        for(int i=0;i<n;i++){
            int b = fib+a;
            fib =a;
            a = b;
        }
        return fib;

    }

}