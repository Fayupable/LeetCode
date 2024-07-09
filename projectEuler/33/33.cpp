#include <iostream>
#include <numeric>

// Custom GCD function using Euclidean algorithm
int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

int main() {
    int productNum = 1, productDen = 1;

    for (int numerator = 10; numerator <= 99; ++numerator) {
        for (int denominator = numerator + 1; denominator <= 99; ++denominator) {
            int nUnits = numerator % 10, nTens = numerator / 10;
            int dUnits = denominator % 10, dTens = denominator / 10;

            if (nUnits == 0 && dUnits == 0) continue;

            if (nUnits == dTens && dUnits != 0 && nTens * denominator == numerator * dUnits) {
                productNum *= nTens;
                productDen *= dUnits;
            } else if (nTens == dUnits && dTens != 0 && nUnits * denominator == numerator * dTens) {
                productNum *= nUnits;
                productDen *= dTens;
            }
        }
    }

    int gcdValue = gcd(productNum, productDen);
    productNum /= gcdValue;
    productDen /= gcdValue;

    std::cout << "The denominator of the product in its lowest terms is: " << productDen << std::endl;
    return 0;
}