class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            // Extract the age part (characters 11 and 12)
            String ageString = detail.substring(11, 13);
            int age = Integer.parseInt(ageString);
            // Check if the age is strictly more than 60
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}

/*
 * class Solution {
 * 
 * public int countSeniors(String[] details) {
 * int seniorCount = 0;
 * 
 * // Iterate through each passenger's details
 * for (String passengerInfo : details) {
 * // Extract the digits of age
 * int ageTens = passengerInfo.charAt(11) - '0';
 * int ageOnes = passengerInfo.charAt(12) - '0';
 * 
 * // Calculate the full age
 * int age = ageTens * 10 + ageOnes;
 * 
 * // Check if the passenger is a senior (strictly over 60 years old)
 * if (age > 60) {
 * seniorCount++;
 * }
 * }
 * 
 * return seniorCount;
 * }
 * }
 */