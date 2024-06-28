#include <iostream>
#include <vector>
#include <numeric>


using namespace std;

// Function to multiply a large number (represented as a vector) by an integer
void multiply(vector<int>& number, int n) {
    int carry = 0;
    for (auto& digit : number) {
        int product = digit * n + carry;
        digit = product % 10;
        carry = product / 10;
    }
    while (carry) {
        number.push_back(carry % 10);
        carry /= 10;
    }
}

// Function to calculate the sum of digits of factorial
int factorialDigitSum(int n) {
    vector<int> fact = {1}; // Initialize with factorial of 0
    for (int i = 1; i <= n; ++i) {
        multiply(fact, i);
    }
    return accumulate(fact.begin(), fact.end(), 0);
}

int main() {
    cout << factorialDigitSum(100) << endl;
    return 0;
}