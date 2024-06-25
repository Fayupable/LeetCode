#include <iostream>
#include <vector>

// Function to calculate the sum of digits of 2^n
int powerDigitSum(int n) {
    // Using a vector to store digits of the result
    std::vector<int> digits;
    digits.push_back(1); // Start with 2^0 = 1

    // Perform exponentiation by squaring
    for (int i = 0; i < n; ++i) {
        int carry = 0;
        for (size_t j = 0; j < digits.size(); ++j) {
            int product = digits[j] * 2 + carry;
            digits[j] = product % 10;
            carry = product / 10;
        }
        while (carry > 0) {
            digits.push_back(carry % 10);
            carry /= 10;
        }
    }

    // Calculate the sum of digits
    int sum = 0;
    for (size_t i = 0; i < digits.size(); ++i) {
        sum += digits[i];
    }

    return sum;
}

int main() {
    int exponent = 1000;
    std::cout << "Sum of digits of 2^" << exponent << ": " << powerDigitSum(exponent) << std::endl;
    return 0;
}