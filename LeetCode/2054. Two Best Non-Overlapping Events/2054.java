class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int maxSingleValue = 0;
        int maxSum = 0;

        for (int[] event : events) {
            maxSingleValue = Math.max(maxSingleValue, event[2]);
            Integer prevEndTime = map.floorKey(event[0] - 1);
            int prevMax = prevEndTime == null ? 0 : map.get(prevEndTime);
            maxSum = Math.max(maxSum, prevMax + event[2]);
            map.put(event[1], Math.max(map.getOrDefault(event[1], 0), maxSingleValue));
        }

        return maxSum;
    }
}