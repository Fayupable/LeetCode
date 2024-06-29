#include <iostream>

// Function to calculate the sum of divisors of a number
int sumOfDivisors(int n) {
    int sum = 0;
    for (int i = 1; i < n; ++i) {
        if (n % i == 0) {
            sum += i;
        }
    }
    return sum;
}

// Function to find the sum of all amicable numbers under n
int amicableNumbers(int n) {
    int sum = 0;
    for (int i = 1; i < n; ++i) {
        int sumDivisors = sumOfDivisors(i);
        if (sumOfDivisors(sumDivisors) == i && sumDivisors != i) {
            sum += i;
        }
    }
    return sum;
}

int main() {
    std::cout << amicableNumbers(10000) << std::endl;
    return 0;
}