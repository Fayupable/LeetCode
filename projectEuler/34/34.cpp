// Digit Factorials
// 145 = 1! + 4! + 5! = 1 + 24 + 120 = 145

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int factorial(int n) {
    if (n == 0) return 1;
    int result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}

int main() {
    vector<int> factorials(10);
    for (int i = 0; i < 10; i++) {
        factorials[i] = factorial(i);
    }

    int result = 0;
    for (int i = 10; i < 1000000; i++) {
        int sum = 0;
        int n = i;
        while (n > 0) {
            sum += factorials[n % 10];
            n /= 10;
        }
        if (sum == i) {
            result += i;
        }
    }
    cout << result << endl;
    return 0;
}
