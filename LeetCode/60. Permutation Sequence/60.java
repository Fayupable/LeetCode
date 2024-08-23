import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
    
        List<Integer> numbers = initializeNumbers(n);
        
    
        int[] factorial = computeFactorials(n);
        
    
        k--;
        
    
        return buildPermutation(n, k, numbers, factorial);
    }
    
    
    private List<Integer> initializeNumbers(int n) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        return numbers;
    }
    
    
    private int[] computeFactorials(int n) {
        int[] factorial = new int[n];
        factorial[0] = 1;  // 0! = 1
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        return factorial;
    }
    
    private String buildPermutation(int n, int k, List<Integer> numbers, int[] factorial) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorial[i];
        }
        
        return sb.toString();
    }
}