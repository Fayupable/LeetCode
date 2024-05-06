class Solution:
    def addBinary(self, a, b):
        # Initialize the indices for both strings
        index_a, index_b = len(a) - 1, len(b) - 1
        carry = 0
        result = []

        # Traverse both strings from right to left
        while index_a >= 0 or index_b >= 0 or carry:
            sum = carry
            if index_a >= 0:
                sum += int(a[index_a])
                index_a -= 1
            if index_b >= 0:
                sum += int(b[index_b])
                index_b -= 1

            # Append current bit to result array
            result.append(sum % 2)
            # Update carry
            carry = sum // 2

        # Reverse the result list to form the final binary string
        return ''.join(str(x) for x in reversed(result))
