class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canDistribute(quantities, n, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }

    private boolean canDistribute(int[] quantities, int n, int maxProductsPerStore) {
        int requiredStores = 0;
        for (int quantity : quantities) {
            requiredStores += (quantity + maxProductsPerStore - 1) / maxProductsPerStore;
            if (requiredStores > n) {
                return false;
            }
        }
        return requiredStores <= n;
    }
}