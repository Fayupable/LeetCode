/*
#Number Spiral Diagonals
#Problem 28

#sum of diagonals 1001 by 1001 spiral
*/

#include <iostream>
#include <vector>
#include <cmath>

int main() {
    int n = 1001;
    int sum = 1;
    for (int i = 3; i <= n; i += 2) {
        sum += 4 * i * i - 6 * i + 6;
    }
    std::cout << sum << std::endl;
    return 0;
}