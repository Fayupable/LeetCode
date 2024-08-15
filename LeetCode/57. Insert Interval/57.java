import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return convertListToArray(result);
    }

    private int[][] convertListToArray(List<int[]> list) {
        int[][] array = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals1 = { { 1, 3 }, { 6, 9 } };
        int[] newInterval1 = { 2, 5 };
        int[][] result1 = solution.insert(intervals1, newInterval1);
        printResult(result1);

        int[][] intervals2 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval2 = { 4, 8 };
        int[][] result2 = solution.insert(intervals2, newInterval2);
        printResult(result2);
    }

    private static void printResult(int[][] intervals) {
        for (int[] interval : intervals) {
            System.out.print("[" + interval[0] + "," + interval[1] + "] ");
        }
        System.out.println();
    }
}

/*
 * import java.util.Arrays;
 * 
 * public class Solution {
 * public int[][] insert(int[][] intervals, int[] newInterval) {
 * int n = intervals.length;
 * int l = 0;
 * int r = n - 1;
 * while (l < n && newInterval[0] > intervals[l][1]) {
 * l++;
 * }
 * while (r >= 0 && newInterval[1] < intervals[r][0]) {
 * r--;
 * }
 * int[][] res = new int[l + n - r][2];
 * for (int i = 0; i < l; i++) {
 * res[i] = Arrays.copyOf(intervals[i], intervals[i].length);
 * }
 * res[l][0] = Math.min(newInterval[0], l == n ? newInterval[0] :
 * intervals[l][0]);
 * res[l][1] = Math.max(newInterval[1], r == -1 ? newInterval[1] :
 * intervals[r][1]);
 * for (int i = l + 1, j = r + 1; j < n; i++, j++) {
 * res[i] = intervals[j];
 * }
 * return res;
 * }
 * }
 */

/*
 * class Solution {
 * public int[][] insert(int[][] intervals, int[] newInterval) {
 * List<int []> inters = new ArrayList<>();
 * int k = 1;
 * int [] check = new int[2];
 * check[0] = newInterval[0]; check[1] = newInterval[1];
 * for(int i = 0; i<intervals.length; i++){
 * int [] curr = intervals[i];
 * if((check[0] >= curr[0] && check[1] <= curr[1])) return intervals;
 * if(curr[1] < check[0]){
 * inters.add(curr);
 * }
 * else if(curr[0] < check[0] && curr[1] <= check[1] && curr[1] >= check[0]){
 * check[0] = curr[0];
 * }else if(curr[0] > check[0] && curr[0] <= check[1] && curr[1] > check[1]){
 * check[1] = curr[1];
 * }else if(curr[0] >= check[0] && curr[1] <= check[1]){
 * }else if(check[1] < curr[0]){
 * if(k == 1){
 * inters.add(check);
 * k++;
 * }
 * inters.add(curr);
 * }
 * }
 * if(k == 1){
 * inters.add(check);
 * }
 * int [][] res = new int[(inters.size() == 0)?1:inters.size()][2];
 * for(int o = 0; o < res.length && inters.size()!=0; o++){
 * int [] boo = inters.get(o);
 * res[o][0] = boo[0];
 * res[o][1] = boo[1];
 * }
 * if(inters.size() == 0){
 * res[0] = newInterval;
 * }
 * return res;
 * }
 * }
 */