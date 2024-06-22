#include <iostream>
#include <fstream>
#include <vector>
#include <string>

// Function definition
std::string sumOfNumbersDigits(const std::vector<std::string>& numbers) {
    unsigned long long totalSum = 0;

    for (std::vector<std::string>::const_iterator it = numbers.begin(); it != numbers.end(); ++it) {
        totalSum += std::stoull(it->substr(0, 15)); // Take the first 15 digits of the number
    }

    return std::to_string(totalSum).substr(0, 10); // Return the first 10 digits of the total sum
}

int main() {
    // Add your txt file path here
    std::string path = "projectEuler/13/13.txt"; // Path variable for the file
    std::ifstream file(path); // Use the path variable to open the file
    std::vector<std::string> numbers;
    // Read the file line by line and store the numbers in a vector
    std::string line;

    if (file.is_open()) {
        while (std::getline(file, line)) {
            numbers.push_back(line);
        }
        file.close();
    } else {
        std::cerr << "File could not be opened: " << path << std::endl;
        return 1;
    }

    std::cout << sumOfNumbersDigits(numbers) << std::endl;

    return 0;
}