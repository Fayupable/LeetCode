class Solution(object):
    def divide(self, dividend, divisor):
        # Define the maximum and minimum integer values
        INT_MAX = 2**31 - 1
        INT_MIN = -2**31

        # Handle overflow. If dividend is the smallest integer and divisor is -1, the result overflows.
        if dividend == INT_MIN and divisor == -1:
            return INT_MAX

        # Determine sign of the result. If dividend and divisor have different signs, the result is negative.
        negative = (dividend < 0) ^ (divisor < 0)

        # Take absolute values of dividend and divisor to handle negative numbers
        dividend, divisor = abs(dividend), abs(divisor)

        # Initialize result
        result = 0

        # While the dividend is greater than or equal to the divisor
        while dividend >= divisor:
            # Initialize temp as divisor and multiple as 1
            temp, multiple = divisor, 1

            # Double temp and multiple while dividend is greater than or equal to 2*temp
            while dividend >= temp << 1:
                temp <<= 1
                multiple <<= 1

            # Subtract temp from dividend and add multiple to result
            dividend -= temp
            result += multiple

        # If the result is negative, convert it to negative. Otherwise, leave it as is.
        return -result if negative else result