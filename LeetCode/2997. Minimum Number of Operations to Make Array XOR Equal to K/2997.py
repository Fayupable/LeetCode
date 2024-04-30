class Solution(object):
    def minOperations(self, nums, k):
        final_xor = 0
        # Dizideki tüm tamsayıların XOR'u.
        for n in nums:
            final_xor ^= n
        
        count = 0
        # k ve final_xor sıfır olana kadar döngüyü sürdür.
        while k > 0 or final_xor > 0:
            # k ve final_xor'un en sağdaki bitlerini karşılaştır.
            if k & 1 != final_xor & 1:
                count += 1
            
            # Her iki tamsayıdan da son bit kaldırılır.
            k >>= 1
            final_xor >>= 1
        
        return count
