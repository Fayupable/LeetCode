class Solution {
    public int findCenter(int[][] edges) {
        // Compare the nodes of the first two edges to find the common one
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
}
