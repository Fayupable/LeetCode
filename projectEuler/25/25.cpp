#include <iostream>
#include <vector>

int main() {

    int arr[] = {1};
    std::vector<int> a(arr, arr + sizeof(arr) / sizeof(arr[0]));
    int arr2[] = {1};
    std::vector<int> b(arr2, arr2 + sizeof(arr2) / sizeof(arr2[0]));

    int index = 2;

    while (b.size() < 1000) {
        index++;

        // Calculate the next Fibonacci number
        std::vector<int> next(b.size() + 1, 0);
        for (int i = 0; i < a.size(); i++) {
            next[i] += a[i];
        }
        for (int i = 0; i < b.size(); i++) {
            next[i] += b[i];
            if (next[i] >= 10) {
                next[i] -= 10;
                next[i + 1]++;
            }
        }
        if (next.back() == 0) {
            next.pop_back();
        }

        // Move to the next pair of Fibonacci numbers
        a = b;
        b = next;
    }

    std::cout << "Time: " << clock() / (double) CLOCKS_PER_SEC << std::endl;
    std::cout << index << std::endl;
    return 0;
}

