class Solution {

    // Function to parse a fraction from a string
    private int[] parseFraction(String fraction) {
        String[] parts = fraction.split("/");
        int numerator = Integer.parseInt(parts[0]);
        int denominator = Integer.parseInt(parts[1]);
        return new int[]{numerator, denominator};
    }

    // Function to add two fractions
    private int[] addFractions(int[] frac1, int[] frac2) {
        int numerator1 = frac1[0];
        int denominator1 = frac1[1];
        int numerator2 = frac2[0];
        int denominator2 = frac2[1];

        // Calculate the numerator and denominator for the resulting fraction
        int numerator = numerator1 * denominator2 + numerator2 * denominator1;
        int denominator = denominator1 * denominator2;

        // Simplify the fraction
        int gcdValue = gcd(Math.abs(numerator), denominator);
        return new int[]{numerator / gcdValue, denominator / gcdValue};
    }

    // Function to calculate the greatest common divisor (GCD)
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Main function to handle the entire expression
    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;

        // Split the expression into individual fractions and operators
        int i = 0;
        while (i < expression.length()) {
            int sign = 1;
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }
            int j = i;
            while (j < expression.length() && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                j++;
            }
            int[] currentFraction = parseFraction(expression.substring(i, j));
            currentFraction[0] *= sign;

            int[] resultFraction = addFractions(new int[]{numerator, denominator}, currentFraction);
            numerator = resultFraction[0];
            denominator = resultFraction[1];

            i = j;
        }

        return numerator + "/" + denominator;
    }
}