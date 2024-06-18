#include <iostream>
#include <cmath>

long long largestPrimeFactor(long long n) {
    long long largest = -1;

    // Divide out the factor of 2
    while (n % 2 == 0) {
        largest = 2;
        n /= 2;
    }

    // Divide out odd factors from 3 upwards
    for (long long i = 3; i <= sqrt(n); i += 2) {
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

int main() {
    long long number = 600851475143;
    std::cout << "The largest prime factor of " << number << " is " << largestPrimeFactor(number) << std::endl;
    return 0;
}