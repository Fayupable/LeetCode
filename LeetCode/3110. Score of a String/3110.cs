public int ScoreOfString(string s) { // Define a public method named ScoreOfString that takes a string s as input
    int score = 0; // Initialize a variable to keep track of the score. The initial value is 0.
    for (int i = 1; i < s.Length; i++) { // Loop through all characters of the string, starting from the second character
        score += Math.Abs(s[i] - s[i - 1]); // Subtract the ASCII value of the previous character from the ASCII value of the current character, take the absolute value of this subtraction, and add it to the total score.
    }
    return score; // Return the total score.
}

    /*

public class Solution {
    public int ScoreOfString(string s) 
    {
        int result=0;
for(int i = 0; i < s.Length -1; i++)
{
    int delta = (int)s[i] - (int)s[i + 1];
    if(delta<0)
    delta = -delta;
    result += delta;
}
return result;  
    }
}
    */

