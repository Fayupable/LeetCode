//circular primes

#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int is_prime(int n) {
    if (n < 2) return 0;
    if (n == 2) return 1;
    if (n % 2 == 0) return 0;
    for (int i = 3; i <= sqrt(n); i += 2) {
        if (n % i == 0) return 0;
    }
    return 1;
}

int is_circular_prime(int n) {
    vector<int> digits;
    int temp = n;
    while (temp > 0) {
        digits.push_back(temp % 10);
        temp /= 10;
    }
    reverse(digits.begin(), digits.end());
    for (int i = 0; i < digits.size(); i++) {
        int num = 0;
        for (int j = 0; j < digits.size(); j++) {
            num = num * 10 + digits[(i + j) % digits.size()];
        }
        if (!is_prime(num)) return 0;
    }
    return 1;
}

int main() {
    int count = 0;
    for (int i = 2; i < 1000000; i++) {
        if (is_circular_prime(i)) count++;
    }
    cout << count << endl;
    return 0;
}