#Digit Fifth Powers
#Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

def digitFifthPowers():
    fifthPowers = []
    for i in range(2,1000000):
        if i == sum([int(x)**5 for x in str(i)]):
            fifthPowers.append(i)
    return sum(fifthPowers)

print(digitFifthPowers())