class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();
        int maxRows = 0;

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            StringBuilder flippedPattern = new StringBuilder();

            for (int cell : row) {
                pattern.append(cell);
                flippedPattern.append(1 - cell);
            }

            String patternStr = pattern.toString();
            String flippedPatternStr = flippedPattern.toString();

            patternCount.put(patternStr, patternCount.getOrDefault(patternStr, 0) + 1);
            patternCount.put(flippedPatternStr, patternCount.getOrDefault(flippedPatternStr, 0) + 1);

            maxRows = Math.max(maxRows, Math.max(patternCount.get(patternStr), patternCount.get(flippedPatternStr)));
        }

        return maxRows;
    }
}