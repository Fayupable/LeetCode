class Solution { // Define a class named Solution
    public int addDigits(int num) { // Define a public method named addDigits that takes an integer num as input
        while(num >= 10){ // While the number is greater than or equal to 10
            String numStr = Integer.toString(num); // Convert the number to a string
            num = 0; // Reset the number to 0
            for(char c: numStr.toCharArray()){ // For each character in the string (which represents a digit of the number)
                num += c - '0'; // Convert the character to an integer and add it to the number
            }
        }
        return num; // Return the number
    }
}

/*
 class Solution {
    public int addDigits(int num) {
        if(num==0)
        return 0;
        else if(num%9==0)
        return 9;
        else
        return num%9;
    }
}
 */
/*
 class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            String numStr = Integer.toString(num);
            int sum = 0;
            for (int i = 0; i < numStr.length(); i++) {
                sum += numStr.charAt(i) - '0';
            }
            num = sum;
        }
        return num;

    }
}
 */