//What is the 10001st prime number?
#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

// Function to find the nth prime number
int nthPrime(int n) {
    // 2 is the only even prime number
    vector<int> primes;
    primes.push_back(2);
    int num = 3;
    while (primes.size() < n) {
        // Check if num is divisible by any prime number less than its square root
        bool isPrime = true;
        for (int prime : primes) {
            // If num is not divisible by any prime number less than its square root, it is a prime number
            if (prime > sqrt(num)) {
                break;
            }
            if (num % prime == 0) {
                // If num is divisible by any prime number less than its square root, it is not a prime number
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            // Add num to the list of prime numbers
            primes.push_back(num);
        }
        // Check only odd numbers
        num += 2;
    }
    // Return the nth prime number
    return primes.back();
}

int main() {
    cout << nthPrime(10001) << endl;
    return 0;
}
