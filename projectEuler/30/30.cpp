//Digit Fifth Powers
//Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int main(){
    vector<int> v;
    for (int i = 2; i < 1000000; i++) {
        int sum = 0;
        int temp = i;
        while (temp > 0) {
            sum += pow(temp % 10, 5);
            temp /= 10;
        }
        if (sum == i) {
            v.push_back(i);
        }
    }
}


