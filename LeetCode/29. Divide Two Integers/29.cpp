#include <climits>
#include <cmath>

class Solution {
public:
    int divide(int dividend, int divisor) {
        // Handle special case of overflow
        // If dividend is INT_MIN (smallest integer) and divisor is -1, the division result overflows
        if (dividend == INT_MIN && divisor == -1) {
            return INT_MAX;  // Return INT_MAX to avoid overflow
        }

        // Determine the sign of the result
        // If dividend and divisor have different signs, the result is negative
        bool isNegative = (dividend < 0) ^ (divisor < 0);

        // Use long long type to avoid overflow issues during abs calculation
        // Convert dividend and divisor to their absolute values
        long long dividendLL = labs(dividend);
        long long divisorLL = labs(divisor);

        // Initialize result
        long long result = 0;

        // Declare temp and multiple variables for later use
        long long temp, multiple;

        // Bit shift to double the divisor until it's the largest multiple less than dividend
        while (dividendLL >= divisorLL) {
            temp = divisorLL;  // Start with the divisor
            multiple = 1;  // Start with a multiple of 1

            // Keep doubling the divisor and the multiple as long as the dividend is larger
            while (dividendLL >= (temp << 1)) {
                temp <<= 1;  // Double the divisor
                multiple <<= 1;  // Double the multiple
            }

            // Subtract the largest found multiple of divisor from dividend
            dividendLL -= temp;

            // Add the multiple to the result
            result += multiple;
        }

        // Apply the sign to the result
        // If the result is supposed to be negative, return its negative value
        // Otherwise, return the result as is
        return isNegative ? -result : result;
    }
};