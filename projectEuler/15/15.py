import math
import math

def count_routes(n):
    """
    Calculates the number of routes in an n x n grid from top-left to bottom-right corner.

    Explanation:
    The number of routes in an n x n grid, where you can only move right or down, is given
    by the combination formula C(2n, n), which equals (2n)! / (n! * n!).

    This formula counts all possible combinations of moves without backtracking.

    Args:
    - n (int): Size of the grid (e.g., for a 20x20 grid, n = 20).

    Returns:
    - int: Number of routes from top-left to bottom-right corner.
    """
    # Calculate factorial of 2n
    numerator = math.factorial(2 * n)

    # Calculate factorial of n
    denominator = math.factorial(n)

    # Calculate (2n)! / (n! * n!)
    routes = numerator // (denominator * denominator)
    return routes

# Example usage for a 20x20 grid
grid_size = 20
routes = count_routes(grid_size)
print(f"Number of routes in a {grid_size}x{grid_size} grid: {routes}")

# def lattice_paths(n):
#     return math.factorial(2*n) / (math.factorial(n) ** 2)

# grid_size = 20
# print(lattice_paths(grid_size))
