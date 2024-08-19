class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minVal = arrays.get(0).get(0); 
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1); 
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int currentMin = array.get(0);
            int currentMax = array.get(array.size() - 1);

            maxDistance = Math.max(maxDistance, calculateDistance(maxVal, currentMin));
            maxDistance = Math.max(maxDistance, calculateDistance(currentMax, minVal));

            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }

        return maxDistance;
    }

    private int calculateDistance(int a, int b) {
        return Math.abs(a - b);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> arrays = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(1, 2, 3)
        );
        int result = solution.maxDistance(arrays);
        System.out.println(result);
    }
}