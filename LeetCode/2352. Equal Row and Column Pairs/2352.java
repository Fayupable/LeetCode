class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            StringBuilder rowKey = new StringBuilder();
            for (int j = 0; j < n; j++) {
                rowKey.append(grid[i][j]).append(",");
            }
            rowMap.put(rowKey.toString(), rowMap.getOrDefault(rowKey.toString(), 0) + 1);
        }

        for (int j = 0; j < n; j++) {
            StringBuilder colKey = new StringBuilder();
            for (int i = 0; i < n; i++) {
                colKey.append(grid[i][j]).append(",");
            }
            count += rowMap.getOrDefault(colKey.toString(), 0);
        }

        return count;
    }
}