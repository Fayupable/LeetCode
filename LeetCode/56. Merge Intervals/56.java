import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Sort the intervals based on the starting times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (canMerge(currentInterval, intervals[i])) {
                currentInterval = mergeIntervals(currentInterval, intervals[i]);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        mergedIntervals.add(currentInterval);

        return convertListToArray(mergedIntervals);
    }

    private boolean canMerge(int[] interval1, int[] interval2) {
        return interval1[1] >= interval2[0];
    }

    private int[] mergeIntervals(int[] interval1, int[] interval2) {
        return new int[] { interval1[0], Math.max(interval1[1], interval2[1]) };
    }

    private int[][] convertListToArray(List<int[]> list) {
        int[][] array = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}

/*
 * class Solution {
 * public int[][] merge(int[][] intervals) {
 * if (intervals.length == 1) {
 * return intervals;
 * }
 * int max = 0;
 * for (int i = 0; i < intervals.length; i++) {
 * max = Math.max(intervals[i][0], max);
 * }
 * if (max == 0) {
 * return new int[][] { intervals[0] };
 * }
 * int[] timeTable = new int[max + 1];
 * for (int i = 0; i < intervals.length; i++) {
 * int startTime = intervals[i][0];
 * int endTime = intervals[i][1];
 * timeTable[startTime] = Math.max(endTime + 1, timeTable[startTime]);
 * }
 * int resultSize = 0, currEnd = -1, currStart = -1;
 * for (int i = 0; i < timeTable.length; i++) {
 * if (timeTable[i] != 0) {
 * if (currStart == -1) {
 * currStart = i;
 * }
 * currEnd = Math.max(timeTable[i] - 1, currEnd);
 * }
 * if (currEnd == i) {
 * intervals[resultSize++] = new int[] { currStart, currEnd };
 * currEnd = -1;
 * currStart = -1;
 * }
 * }
 * if (currStart != -1) {
 * intervals[resultSize++] = new int[] { currStart, currEnd };
 * }
 * if (intervals.length == resultSize) {
 * return intervals;
 * }
 * int[][] res = new int[resultSize][];
 * for (int i = 0; i < resultSize; i++) {
 * res[i] = intervals[i];
 * }
 * return res;
 * }
 * }
 */