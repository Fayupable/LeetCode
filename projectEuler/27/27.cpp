#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>

// Function to check if a number is prime
bool is_prime(int n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;
    for (int i = 5; i * i <= n; i += 6) {
        if (n % i == 0 || n % (i + 2) == 0) return false;
    }
    return true;
}

// Function to find the number of consecutive primes produced by the quadratic formula
int consecutive_primes(int a, int b) {
    int n = 0;
    while (true) {
        int result = n * n + a * n + b;
        if (!is_prime(result)) {
            break;
        }
        n++;
    }
    return n;
}

int main() {
    int max_a = 0;
    int max_b = 0;
    int max_primes = 0;

    // Iterate over all possible values of a and b
    for (int a = -999; a < 1000; a++) {
        for (int b = -1000; b <= 1000; b++) {
            int primes = consecutive_primes(a, b);
            if (primes > max_primes) {
                max_primes = primes;
                max_a = a;
                max_b = b;
            }
        }
    }

    std::cout << "The product of the coefficients a and b that produces the maximum number of primes is: "
              << (max_a * max_b) << std::endl;
    std::cout << "a: " << max_a << ", b: " << max_b << ", number of primes: " << max_primes << std::endl;

    return 0;
}