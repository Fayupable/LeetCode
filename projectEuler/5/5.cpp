// Function to calculate the Greatest Common Divisor (GCD) of two numbers
int gcd(int a, int b) {
    while (b != 0) {
        // Update a to b and b to the remainder of a divided by b
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

// Function to calculate the Least Common Multiple (LCM) of two numbers
int lcm(int a, int b) {
    // The LCM of two numbers is their product divided by their GCD
    return a * (b / gcd(a, b));
}

// Function to calculate the LCM of multiple numbers
int lcm_multiple(int limit) {
    // Initialize the result as 1
    int result = 1;
    // Iterate over the numbers from 2 to the limit
    for (int i = 2; i <= limit; ++i) {
        // Update the result to the LCM of the current result and the current number
        result = lcm(result, i);
    }
    // Return the result
    return result;
}

int main() {
    // Define the limit as 20
    int limit = 20;
    // Calculate the LCM of all the numbers from 1 to the limit
    int result = lcm_multiple(limit);
    // Print the result
    std::cout << "The smallest positive number that is evenly divisible by all of the numbers from 1 to " << limit << " is: " << result << std::endl;
    // Return 0 to indicate successful execution
    return 0;
}