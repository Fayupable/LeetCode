#include <iostream>
#include <string>

// Function to check if a number is a palindrome
bool isPalindrome(int number) {
    std::string s = std::to_string(number);
    int len = s.length();
    for (int i = 0; i < len / 2; ++i) {
        if (s[i] != s[len - i - 1]) {
            return false;
        }
    }
    return true;
}

// Function to find the largest palindrome made from the product of two 3-digit numbers
int largestPalindromeProduct() {
    int largestPalindrome = 0;

    for (int i = 999; i >= 100; --i) {
        for (int j = i; j >= 100; --j) {
            int product = i * j;
            if (isPalindrome(product) && product > largestPalindrome) {
                largestPalindrome = product;
            }
        }
    }

    return largestPalindrome;
}

int main() {
    std::cout << "The largest palindrome made from the product of two 3-digit numbers is: " << largestPalindromeProduct() << std::endl;
    return 0;
}