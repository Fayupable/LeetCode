#include <iostream> // Include the iostream library to allow for input and output
#include <string>   // Include the string library to use string data type
#include <cmath>    // Include the cmath library to use the abs() function

using namespace std; // Use the standard namespace

class Solution { // Define a class named Solution
public: // Declare the following members as public
    int scoreOfString(string s) { // Define a member function that takes a string and returns an int
        int score = 0; // Initialize a variable to keep track of the score. The initial value is 0.
        for (size_t i = 1; i < s.length(); ++i) { // Loop through all characters of the string, starting from the second character
            score += abs(s[i] - s[i - 1]); // Subtract the ASCII value of the previous character from the ASCII value of the current character, take the absolute value of this subtraction, and add it to the total score.
        }
        return score; // Return the total score.
    }
};


/*
class Solution {
public:
    int scoreOfString(string s) {
        int sum = 0;
        for(int i=0; i<s.size()-1; i++){
            sum += abs( static_cast<int>(s[i]) - static_cast<int>(s[i+1]) );
        }   // for - i
        return sum;
    }
};
*/
/*
class Solution {
public:
    Solution() {
        std::ios_base::sync_with_stdio(false);
        std::cin.tie(nullptr);
        std::cout.tie(nullptr);
    }
    int scoreOfString(string s) {
        int result = 0;
        for(int i=1;i<s.length();i++){
            result += abs(s[i] - s[i-1]);
        }
        return result;
    }
};
*/