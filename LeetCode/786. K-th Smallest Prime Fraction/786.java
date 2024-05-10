class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0, right = 1, mid;
        int[] result = new int[2];

        while (right - left > 1e-9) { // Tolerance for floating point comparison
            mid = left + (right - left) / 2;
            int total = 0, num = 0, den = 1; // Default values for den should be non-zero to avoid division by zero
            double maxFrac = 0.0; // Track the largest fraction less than mid

            // Use two-pointer technique to count fractions and find the largest fraction less than mid
            for (int i = 0, j = 1; i < n - 1; i++) {
                while (j < n && arr[i] > mid * arr[j]) {
                    j++;
                }

                total += n - j;

                if (j < n && arr[i] * 1.0 / arr[j] > maxFrac) {
                    maxFrac = arr[i] * 1.0 / arr[j];
                    num = i;
                    den = j;
                }
            }

            if (total < k) {
                left = mid; // Fewer than k fractions are less than mid, need to increase mid
            } else {
                right = mid; // At least k fractions are less than or equal to mid, try a smaller mid
                result[0] = arr[num]; // Best fraction found in this iteration
                result[1] = arr[den];
            }
        }

        return result;
    }
}
