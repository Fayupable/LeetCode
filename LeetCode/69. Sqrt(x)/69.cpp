#include <cmath>

class Solution {
public:
    int mySqrt(int x) {
        if (x < 2) return x;

        long long x0 = x, x1;
        while (true) {
            x1 = (x0 + x / x0) / 2;
            if (x0 - x1 < 1)
                break;
            x0 = x1;
        }
        return x0;
    }
};
