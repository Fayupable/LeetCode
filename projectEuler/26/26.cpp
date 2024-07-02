#include <iostream>
#include <vector>
#include <unordered_map>

// Function to get the length of the recurring cycle in the decimal fraction of 1/d
int get_recurring_cycle_length(int d) {
    std::unordered_map<int, int> remainders;
    int value = 1;
    int position = 0;

    while (value != 0) {
        if (remainders.find(value) != remainders.end()) {
            return position - remainders[value];
        }
        remainders[value] = position;
        value = (value * 10) % d;
        position++;
    }

    return 0;
}

// Function to find the number less than limit with the longest recurring cycle in its decimal fraction part
int find_longest_recurring_cycle(int limit) {
    int max_length = 0;
    int max_d = 0;

    for (int d = 2; d < limit; ++d) {
        int cycle_length = get_recurring_cycle_length(d);
        if (cycle_length > max_length) {
            max_length = cycle_length;
            max_d = d;
        }
    }

    return max_d;
}

int main() {
    int limit = 1000;
    int result = find_longest_recurring_cycle(limit);
    std::cout << "The value of d < " << limit << " for which 1/d has the longest recurring cycle is: " << result << std::endl;
    return 0;
}