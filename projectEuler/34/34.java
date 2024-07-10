// Digit Factorials
// 145 = 1! + 4! + 5! = 1 + 24 + 120 = 145

public class 34 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 3; i < 1000000; i++) {
            if (i == sumFactorial(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public static int sumFactorial(int n) {
        int sum = 0;
        while (n > 0) {
            sum += factorial(n % 10);
            n /= 10;
        }
        return sum;
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
