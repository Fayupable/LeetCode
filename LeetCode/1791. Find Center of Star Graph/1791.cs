public class Solution {
    public int FindCenter(int[][] edges) {

        // The center of the star graph is the node that is connected to all other nodes.
        // So, we can just check the first two edges and return the common node.
        return edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1] ? edges[0][0] : edges[0][1];
        
        
    }
}