#include <fstream>
#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>

// Function to calculate the name score
int nameScore(const std::string& name) {
    int score = 0;
    for (char c : name) {
        score += c - 'A' + 1;
    }
    return score;
}

int main() {
    std::string path = "your txt file path";
    std::ifstream file(path);
    std::string data;
    std::getline(file, data);
    file.close();

    // Replace quotes and split by comma
    std::vector<std::string> names;
    std::stringstream ss(data);
    std::string name;
    while (std::getline(ss, name, ',')) {
        names.push_back(name.substr(1, name.length() - 2)); // Remove quotes
    }

    // Sort names alphabetically
    std::sort(names.begin(), names.end());

    // Calculate total of all name scores
    long long totalScore = 0;
    for (size_t i = 0; i < names.size(); ++i) {
        totalScore += (i + 1) * nameScore(names[i]);
    }

    std::cout << totalScore << std::endl;

    return 0;
}