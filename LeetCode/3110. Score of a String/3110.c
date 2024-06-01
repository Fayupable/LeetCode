#include <stdlib.h> // Include the stdlib library to use the abs() function

int scoreOfString(char* s) { // Define a function that takes a string and returns an int
    int score = 0; // Initialize a variable to keep track of the score. The initial value is 0.
    for (int i = 1; s[i] != '\0'; i++) { // Loop through all characters of the string, starting from the second character, until the null character is encountered
        score += abs(s[i] - s[i - 1]); // Subtract the ASCII value of the previous character from the ASCII value of the current character, take the absolute value of this subtraction, and add it to the total score.
    }
    return score; // Return the total score.
}
/*
#include <stdio.h>
#include<string.h>
int scoreOfString(char* s) {
    int len = strlen(s);
    int score = 0;
    int temp;
    for (int i = 0; i < len - 1; i++) {
        temp = s[i] - s[i + 1];
        if (temp < 0) {
            temp = temp * -1;
        }
        score += temp;
    }
    return score;
}

*/