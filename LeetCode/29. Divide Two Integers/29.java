class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow cases. If dividend is the smallest integer and divisor is -1, the result overflows.
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign of the result. If dividend and divisor have different signs, the result is negative.
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert dividend and divisor to long and take absolute values to handle negative numbers
        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);

        // Initialize result
        long result = 0;

        // While the dividend is greater than or equal to the divisor
        while (dividendLong >= divisorLong) {
            // Initialize temp as divisor and multiple as 1
            long temp = divisorLong, multiple = 1;

            // Double temp and multiple while dividend is greater than or equal to 2*temp
            while (dividendLong >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            // Subtract temp from dividend and add multiple to result
            dividendLong -= temp;
            result += multiple;
        }

        // If the result is negative, convert it to negative. Otherwise, leave it as is.
        return negative ? (int) -result : (int) result;
    }
}