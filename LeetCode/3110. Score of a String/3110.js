var scoreOfString = function(s) { // Define a function named scoreOfString that takes a string s as input
    let score = 0; // Initialize a variable to keep track of the score. The initial value is 0.
    for (let i = 1; i < s.length; i++) { // Loop through all characters of the string, starting from the second character
        score += Math.abs(s.charCodeAt(i) - s.charCodeAt(i - 1)); // Subtract the ASCII value of the previous character from the ASCII value of the current character, take the absolute value of this subtraction, and add it to the total score.
    }
    return score; // Return the total score.
};

/*
var scoreOfString = function(s) {
    var diff = 0
    var sum = 0
    for(let i =0 ; i<s.length-1 ; i++)
    {
        diff = Math.abs(s.charCodeAt(i)-s.charCodeAt(i+1))
        sum = sum + diff
    }
    return(sum)
};
*/

/*

var scoreOfString = function(s) {
    let tot=0
    for(let i=0;i<s.length-1;i++){
        tot=tot+Math.sqrt((s.charCodeAt(i)-s.charCodeAt(i+1))*(s.charCodeAt(i)-s.charCodeAt(i+1)))


    }
    return tot
};
*/