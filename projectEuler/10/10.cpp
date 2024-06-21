#include <iostream>
#include <cmath>

using namespace std;

bool isPrime(int n) {
    if (n == 1) return false;
    if (n == 2) return true;
    if (n % 2 == 0) return false;
    for (int i = 3; i <= sqrt(n); i += 2) {
        if (n % i == 0) return false;
    }
    return true;
}

long long sumPrimes(int n) {
    long long sum = 0;
    for (int i = 2; i < n; i++) {
        if (isPrime(i)) {
            sum += i;
        }
    }
    return sum;
}

int main() {
    cout << sumPrimes(2000000) << endl;
    return 0;
}