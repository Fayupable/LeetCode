#Work out the first ten digits of the sum of the following one-hundred 50 digit numbers.

#add your path to the file
path = 'projectEuler/13/13.txt'
with open(path, 'r') as f:
    #read the numbers line by line
    numbers = f.readlines()

def sum_of_numbers_digits(numbers):
    sum = 0
    for number in numbers:
        sum += int(number)
    return sum

print(str(sum_of_numbers_digits(numbers))[:10])


