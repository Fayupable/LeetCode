#Longest Collatz Sequence
'''
Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
'''
#(15.313s)
def collatz(n):
    if n % 2 ==0:
        return n/2 #n is even
    else:
        return (3*n)+1 #n is odd

def collatz_sequence(n):
    count = 1
    while n !=1:
        n = collatz(n)
        count += 1
    return count

def longest_collatz_sequence(n):
    max_count = 0
    max_num = 0
    for i in range(1,n):
        count = collatz_sequence(i)
        if count > max_count:
            max_count = count
            max_num = i
    return max_num

print(longest_collatz_sequence(1000000))


# Faster Solution (15.263s)
# def collatz(n):
#     if n % 2 == 0:
#         return n // 2  # n is even
#     else:
#         return 3 * n + 1  # n is odd

# def collatz_sequence_length(n, memo):
#     if n in memo:
#         return memo[n]
    
#     if n == 1:
#         return 1
    
#     next_n = collatz(n)
#     length = 1 + collatz_sequence_length(next_n, memo)
#     memo[n] = length
    
#     return length

# def longest_collatz_sequence(limit):
#     max_count = 0
#     max_num = 0
#     memo = {}
    
#     for i in range(1, limit):
#         count = collatz_sequence_length(i, memo)
#         if count > max_count:
#             max_count = count
#             max_num = i
            
#     return max_num

# print(longest_collatz_sequence(1000000))