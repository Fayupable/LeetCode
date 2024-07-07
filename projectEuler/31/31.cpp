#include <iostream>
#include <vector>

int coinSums(int n) {
    std::vector<int> coins = {1, 2, 5, 10, 20, 50, 100, 200};
    std::vector<int> ways(n + 1, 0);
    ways[0] = 1;

    for (int coin : coins) {
        for (int j = coin; j <= n; ++j) {
            ways[j] += ways[j - coin];
        }
    }

    return ways[n];
}

int main() {
    int target = 200; // 2 £ in pence
    std::cout << "Number of ways to make " << target << " pence: " << coinSums(target) << std::endl;
    return 0;
}