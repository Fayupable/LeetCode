class Solution {
    public int minOperations(int[] nums, int k) {
        int finalXor = 0;
        // Dizideki tüm tamsayıların XOR'u.
        for (int n : nums) {
            finalXor ^= n;
        }
        
        int count = 0;
        // k ve finalXor sıfır olana kadar döngüyü sürdür.
        while (k > 0 || finalXor > 0) {
            // k ve finalXor'un en sağdaki bitlerini karşılaştır.
            if ((k & 1) != (finalXor & 1)) {
                count++;
            }
            
            // Her iki tamsayıdan da son bit kaldırılır.
            k >>= 1;
            finalXor >>= 1;
        }
        
        return count;
    }
}
