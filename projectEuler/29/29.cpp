//Distinct Powers
//how many distinc term a^b for 2<=a<=100 and 2<=b<=100

#include <iostream>
#include <vector>
#include <set>
#include <cmath>

using namespace std;

int main() {
    set<double> s;
    for (int a = 2; a <= 100; a++) {
        for (int b = 2; b <= 100; b++) {
            s.insert(pow(a, b));
        }
    }
    cout << s.size() << endl;
    return 0;
}