#include <iostream>
#include <vector>
#include <numeric>
#include <algorithm>

//Non-Abundant Sums

// Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

std::vector<int> getDivisors(int n) {
    std::vector<int> divisors;

    for (int i = 1; i <= n / 2; i++) {
        // If n is divisible by i, then i is a divisor of n
        if (n % i == 0) {
            // Add i to the list of divisors
            divisors.push_back(i);
        }
    }
    return divisors;
}

bool isAbundant(int n) {
    std::vector<int> divisors = getDivisors(n);
    // Sum all the divisors
    int sum = std::accumulate(divisors.begin(), divisors.end(), 0);
    return sum > n;
}

int main() {
    std::vector<int> abundantNumbers;
    for (int i = 1; i <= 28123; i++) {
        if (isAbundant(i)) {
            abundantNumbers.push_back(i);
        }
    }

    std::vector<int> abundantSums;
    // Find all the sums of abundant numbers
    for (int i = 0; i < abundantNumbers.size(); i++) {
        // Start from i to avoid duplicates
        for (int j = i; j < abundantNumbers.size(); j++) {
            // Add the sum of the two abundant numbers to the list
            abundantSums.push_back(abundantNumbers[i] + abundantNumbers[j]);
        }
    }

    // Sort the list of sums
    std::sort(abundantSums.begin(), abundantSums.end());
    // Remove duplicates
    abundantSums.erase(std::unique(abundantSums.begin(), abundantSums.end()), abundantSums.end());

    int sum = 0;
    for (int i = 1; i <= 28123; i++) {
        if (!std::binary_search(abundantSums.begin(), abundantSums.end(), i)) {
            sum += i;
        }
    }
    //time
    std::cout << "Time: " << clock() / (double) CLOCKS_PER_SEC << std::endl;
    std::cout << sum << std::endl;
    return 0;
}