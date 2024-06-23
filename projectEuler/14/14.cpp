#include <iostream>
#include <unordered_map>

// Function to compute the next number in the Collatz sequence
unsigned long long collatz(unsigned long long n) {
    return (n % 2 == 0) ? (n / 2) : (3 * n + 1);
}

// Function to compute the length of the Collatz sequence using memoization
unsigned long long collatzSequenceLength(unsigned long long n, std::unordered_map<unsigned long long, unsigned long long>& memo) {
    if (memo.find(n) != memo.end()) {
        return memo[n];
    }
    
    if (n == 1) {
        return 1;
    }
    
    unsigned long long next_n = collatz(n);
    unsigned long long length = 1 + collatzSequenceLength(next_n, memo);
    memo[n] = length;
    
    return length;
}

// Function to find the starting number under the given limit that produces the longest Collatz sequence
unsigned long long longestCollatzSequence(unsigned long long limit, std::unordered_map<unsigned long long, unsigned long long>& memo) {
    unsigned long long max_count = 0;
    unsigned long long max_num = 0;
    
    for (unsigned long long i = 1; i < limit; ++i) {
        unsigned long long count = collatzSequenceLength(i, memo);
        if (count > max_count) {
            max_count = count;
            max_num = i;
        }
    }
    
    return max_num;
}

int main() {
    unsigned long long limit = 1000000;
    std::unordered_map<unsigned long long, unsigned long long> memo;

    unsigned long long result = longestCollatzSequence(limit, memo);
    
    // Calculate approximate memory usage
    size_t memory_usage = memo.size() * (sizeof(unsigned long long) + sizeof(unsigned long long) + 16); // Approximate overhead

    std::cout << "The starting number under " << limit << " that produces the longest Collatz sequence is: " << result << std::endl;
    std::cout << "Approximate memory usage: " << memory_usage << " bytes (" << memory_usage / (1024.0 * 1024.0) << " MB)" << std::endl;

    return 0;
}