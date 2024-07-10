#double base palindromes

def is_palindrome(n):
    s = str(n)
    return s == s[::-1]

def is_double_base_palindrome(n):
    return is_palindrome(n) and is_palindrome(bin(n)[2:])

print(sum(i for i in range(1, 1000000) if is_double_base_palindrome(i)))