// Pandigital Products
// We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
// The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
// Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.

#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

int findSumOfPandigitalProducts() {
    set<int> products;
    // The product of two 4-digit numbers is at most 9 digits
    for (int i = 1; i < 10000; i++) {
        // 10000 is the upper bound because 10000 * 10000 = 100000000 which has 9 digits
        for (int j = i; j < 10000; j++) {
            int product = i * j;
            // The product of two 4-digit numbers is at most 9 digits
            string s = to_string(i) + to_string(j) + to_string(product);
            // The product of two 4-digit numbers is at least 4 digits
            if (s.size() > 9) {
                break;
            }
            // The product of two 4-digit numbers is at most 5 digits
            if (s.size() == 9) {
                vector<int> v;
                // Check if the product is pandigital
                for (int k = 0; k < s.size(); k++) {
                    // Convert char to int
                    v.push_back(s[k] - '0');
                }
                // Sort the vector
                sort(v.begin(), v.end());
                // Check if the vector is pandigital
                bool isPandigital = true;
                for (int k = 0; k < v.size(); k++) {
                    if (v[k] != k + 1) {
                        isPandigital = false;
                        break;
                    }
                }
                // If the vector is pandigital
                if (isPandigital) {
                    // Insert the product into the set
                    products.insert(product);
                }
            }
        }
    }
    //Create a variable to store the sum of the products
    int sum = 0;
    // Sum all the products in the set
    for (auto it = products.begin(); it != products.end(); it++) {
        // Add the product to the sum
        sum += *it;
    }
    return sum;
}

int main() {
    cout << findSumOfPandigitalProducts() << endl;
    return 0;
}