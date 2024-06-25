#include <iostream>
#include <vector>

// Function to calculate the number of routes in an n x n grid using dynamic programming
unsigned long long countRoutes(int n) {
    // Create a 2D vector to store the number of routes
    std::vector<std::vector<unsigned long long> > routes(n + 1, std::vector<unsigned long long>(n + 1, 0));

    // Initialize base cases
    routes[0][0] = 1;

    // Fill the routes table using dynamic programming
    for (int i = 0; i <= n; ++i) {
        for (int j = 0; j <= n; ++j) {
            if (i > 0)
                routes[i][j] += routes[i - 1][j];
            if (j > 0)
                routes[i][j] += routes[i][j - 1];
        }
    }

    // The number of routes to the bottom-right corner of an n x n grid
    return routes[n][n];
}

int main() {
    int gridSize = 20;
    unsigned long long routes = countRoutes(gridSize);

    std::cout << "Number of routes in a " << gridSize << "x" << gridSize << " grid: " << routes << std::endl;

    return 0;
}