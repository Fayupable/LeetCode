#include <iostream>
using namespace std;

// Function to calculate sum of squares of first n natural numbers
long long sumOfSquares(int n) {
    return n * (n + 1) * (2 * n + 1) / 6;
}

// Function to calculate square of sum of first n natural numbers
long long squareOfSum(int n) {
    long long sum = n * (n + 1) / 2;
    return sum * sum;
}

// Function to find the difference between square of sum and sum of squares
long long difference(int n) {
    return squareOfSum(n) - sumOfSquares(n);
}

int main() {
    cout << difference(100) << endl;
    return 0;
}

/*
#include <iostream>
using namespace std;

// Function to find the difference between square of sum and sum of squares
long long difference(int n) {
    long long sum = n * (n + 1) / 2;
    long long sumSq = n * (n + 1) * (2 * n + 1) / 6;
    return sum * sum - sumSq;
}

int main() {
    cout << difference(100) << endl;
    return 0;
}
*/