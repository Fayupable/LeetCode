class Solution {
    public int[][] findFarmland(int[][] land) {
        // Get the dimensions of the land matrix
        int m = land.length;
        int n = land[0].length;
        // Initialize an ArrayList to store the result
        List<int[]> result = new ArrayList<>();
        
        // Iterate through each cell in the land matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check if the current cell represents farmland (1)
                if (land[i][j] == 1) {
                    // Initialize variables to track the top left and bottom right corners of the current group
                    int r1 = i, c1 = j, r2 = i, c2 = j;
                    
                    // Find the bottom right corner of the current group
                    while (r2 < m && land[r2][j] == 1) r2++;
                    while (c2 < n && land[i][c2] == 1) c2++;
                    
                    // Mark the farmland of the current group as visited (set to 0)
                    for (int x = r1; x < r2; x++) {
                        for (int y = c1; y < c2; y++) {
                            land[x][y] = 0;
                        }
                    }
                    
                    // Add the coordinates of the current group to the result list
                    result.add(new int[]{r1, c1, r2 - 1, c2 - 1});
                }
            }
        }
        
        // Convert the ArrayList to a 2D array and return
        int[][] resArray = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }
        return resArray;
    }
}
