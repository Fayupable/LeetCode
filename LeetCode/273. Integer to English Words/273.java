class Solution {

    // Arrays for English words representation
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    // Main function to convert number to words
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        StringBuilder words = new StringBuilder();
        int thousandCounter = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                words.insert(0, convertChunk(num % 1000) + THOUSANDS[thousandCounter] + " ");
            }
            num /= 1000;
            thousandCounter++;
        }

        return words.toString().trim();
    }

    // Function to convert numbers less than 1000
    private String convertChunk(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + convertChunk(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + convertChunk(num % 100);
        }
    }

    // Utility function to convert numbers less than 20
    private String convertLessThan20(int num) {
        return LESS_THAN_20[num] + " ";
    }

    // Utility function to convert tens place
    private String convertTens(int num) {
        return TENS[num / 10] + " " + convertLessThan20(num % 10);
    }

    // Utility function to convert hundreds place
    private String convertHundreds(int num) {
        return LESS_THAN_20[num / 100] + " Hundred " + convertChunk(num % 100);
    }
}