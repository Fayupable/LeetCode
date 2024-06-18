using System;

public class Solution {
    public static long LargestPrimeFactor(long n) {
        long largest = -1;

        // Divide out the factor of 2
        while (n % 2 == 0) {
            largest = 2;
            n /= 2;
        }

        // Divide out odd factors from 3 upwards
        for (long i = 3; i <= Math.Sqrt(n); i += 2) {
            while (n % i == 0) {
                largest = i;
                n /= i;
            }
        }

        // If n is still greater than 2, then it is prime
        if (n > 2) {
            largest = n;
        }

        return largest;
    }

    public static void Main(string[] args) {
        long number = 600851475143;
        Console.WriteLine("The largest prime factor of " + number + " is " + LargestPrimeFactor(number));
    }
}