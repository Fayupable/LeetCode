class Solution {
    public int minGroups(int[][] intervals) {
        int rangeStart = Integer.MAX_VALUE;
        int rangeEnd = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            rangeStart = Math.min(rangeStart, interval[0]);
            rangeEnd = Math.max(rangeEnd, interval[1]);
        }
        
        int[] pointToCount = new int[rangeEnd - rangeStart + 2];
        for (int[] interval : intervals) {
            pointToCount[interval[0] - rangeStart]++;        
            pointToCount[interval[1] - rangeStart + 1]--;    
        }
        
        int concurrentIntervals = 0;
        int maxConcurrentIntervals = 0;
        for (int count : pointToCount) {
            concurrentIntervals += count;
            maxConcurrentIntervals = Math.max(maxConcurrentIntervals, concurrentIntervals);
        }
        
        return maxConcurrentIntervals;
    }
}
