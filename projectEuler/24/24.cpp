

#include <iostream>
#include <vector>
#include <algorithm>


int main() {
    int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    std::vector<int> digits(arr, arr + sizeof(arr) / sizeof(arr[0]));

    for (int i = 1; i < 1000000; i++) {
        std::next_permutation(digits.begin(), digits.end());
    }

    for (int i = 0; i < digits.size(); i++) {
        std::cout << digits[i];
    }
    std::cout << std::endl;
    std::cout << "Time: " << clock() / (double) CLOCKS_PER_SEC << std::endl;
    return 0;
}

