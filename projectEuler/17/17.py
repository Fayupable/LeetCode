# Function to convert a number to words
def number_to_words(n):
    # Define words for numbers 1 to 19 and multiples of ten up to 90
    ones = ["", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
            "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"]
    tens = ["", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]

    if n == 1000:
        return "onethousand"
    
    words = ""
    # Hundreds place
    if n >= 100:
        words += ones[n // 100] + "hundred"
        if n % 100 != 0:
            words += "and"
    
    # Tens and ones places
    n %= 100
    if n >= 20:
        words += tens[n // 10]
        n %= 10
    words += ones[n]
    
    return words

# Function to count letters in the number words from 1 to 1000
def count_letters_in_numbers(limit):
    total_letters = 0
    for i in range(1, limit + 1):
        word = number_to_words(i)
        total_letters += len(word)
    
    return total_letters

# Calculate the total letters used from 1 to 1000
total_letters = count_letters_in_numbers(1000)
print("Total letters used from 1 to 1000:", total_letters)