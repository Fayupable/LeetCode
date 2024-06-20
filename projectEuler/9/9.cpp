#include <iostream>

using namespace std;

// Find the Pythagorean triplet for which a + b + c = sum
int findPythagoreanTriplet(int sum) {
    // a < b < c
    for (int a = 1; a < sum; a++) {
        for (int b = a + 1; b < sum; b++) {
            // c = sum - a - b
            int c = sum - a - b;
            // a^2 + b^2 = c^2
            if (a * a + b * b == c * c) {
                //print the triplet
                cout << a << " " << b << " " << c << endl;
                return a * b * c;
            }
        }
    }
    return -1;
}

int main() {
    cout << findPythagoreanTriplet(1000) << endl;
    return 0;
}