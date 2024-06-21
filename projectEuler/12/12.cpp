#include <iostream>
#include <cmath>

// Function to count the number of divisors of a given number n
int countDivisors(int n) {
    int count = 0;
    int sqrt_n = static_cast<int>(std::sqrt(n));
    for (int i = 1; i <= sqrt_n; ++i) {
        if (n % i == 0) {
            count += 2; // i and n / i
        }
    }
    if (sqrt_n * sqrt_n == n) {
        count -= 1; // Correct the double count if n is a perfect square
    }
    return count;
}

// Function to find the first triangle number with more than 'divisorLimit' divisors
int findTriangleNumberWithDivisors(int divisorLimit) {
    int n = 1;
    int triangleNumber = 0;
    
    while (true) {
        triangleNumber = n * (n + 1) / 2;
        if (countDivisors(triangleNumber) > divisorLimit) {
            return triangleNumber;
        }
        n++;
    }
}

int main() {
    const int divisorLimit = 500;
    int result = findTriangleNumberWithDivisors(divisorLimit);
    std::cout << "The first triangle number with over " << divisorLimit << " divisors is: " << result << std::endl;
    return 0;
}