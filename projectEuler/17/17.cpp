#include <iostream>
#include <string>
#include <vector>

// Function to convert a number to words
std::string numberToWords(int n) {
    std::vector<std::string> ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                                     "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                                     "seventeen", "eighteen", "nineteen"};
    std::vector<std::string> tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    // Special case for 1000
    if (n == 1000)
        return "onethousand";

    std::string words;
    // Hundreds place
    if (n >= 100) {
        words += ones[n / 100] + "hundred";
        if (n % 100 != 0)
            words += "and";
    }

    // Tens and ones places
    n %= 100;
    if (n >= 20) {
        // Tens place
        words += tens[n / 10];
        // Ones place
        n %= 10;
    }
    // Ones place
    words += ones[n];

    return words;
}

// Function to count letters in the number words from 1 to 1000
int countLettersInNumbers(int limit) {
    // Count the letters in the words of numbers from 1 to limit
    int totalLetters = 0;
    for (int i = 1; i <= limit; ++i) {
        // Convert the number to words
        std::string word = numberToWords(i);
        // Count the letters in the word
        totalLetters += word.length();
    }
    return totalLetters;
}

int main() {
    int totalLetters = countLettersInNumbers(1000);
    std::cout << "Total letters used from 1 to 1000: " << totalLetters << std::endl;
    return 0;
}