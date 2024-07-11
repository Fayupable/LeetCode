// Truncatable Primes
// Find the sum of the only eleven primes that are both truncatable from left to right and right to left.


#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <string>
#include <sstream>

using namespace std;

bool isPrime(int n) {
    if (n < 2) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    for (int i = 3; i <= sqrt(n); i += 2) {
        if (n % i == 0) return false;
    }
    return true;
}

bool isTruncatable(int n) {
    string s = to_string(n);
    for (int i = 1; i < s.size(); i++) {
        if (!isPrime(stoi(s.substr(i))) || !isPrime(stoi(s.substr(0, s.size() - i)))) {
            return false;
        }
    }
    return true;
}

int main() {
    int count = 0;
    int sum = 0;
    for (int i = 10; count < 11; i++) {
        if (isPrime(i) && isTruncatable(i)) {
            count++;
            sum += i;
        }
    }
    cout << sum << endl;
    return 0;
}