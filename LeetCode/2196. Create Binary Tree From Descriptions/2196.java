/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        // Create nodes and build the tree based on descriptions
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            int isLeft = desc[2];

            // Retrieve or create the parent node
            TreeNode parentNode = nodeMap.getOrDefault(parentVal, new TreeNode(parentVal));
            nodeMap.putIfAbsent(parentVal, parentNode);

            // Retrieve or create the child node
            TreeNode childNode = nodeMap.getOrDefault(childVal, new TreeNode(childVal));
            nodeMap.putIfAbsent(childVal, childNode);

            // Assign child node to the correct position
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            // Mark this node as a child
            children.add(childVal);
        }

        // The root is the one node not marked as a child
        TreeNode root = null;
        for (int[] desc : descriptions) {
            if (!children.contains(desc[0])) {
                root = nodeMap.get(desc[0]);
                break;
            }
        }

        return root;
    }
}
/*
 * 
 * class Solution {
 * public TreeNode createBinaryTree(final int[][] descriptions) {
 * final TreeNode[] nodes = new TreeNode[100001];
 * final boolean[] children = new boolean[100001];
 * 
 * for(final int[] description : descriptions) {
 * if(nodes[description[0]] == null)
 * nodes[description[0]] = new TreeNode(description[0]);
 * 
 * if(nodes[description[1]] == null)
 * nodes[description[1]] = new TreeNode(description[1]);
 * 
 * if(description[2] == 0)
 * nodes[description[0]].right = nodes[description[1]];
 * else
 * nodes[description[0]].left = nodes[description[1]];
 * 
 * children[description[1]] = true;
 * }
 * 
 * for(final int[] description : descriptions)
 * if(!children[description[0]])
 * return nodes[description[0]];
 * 
 * return null;
 * }
 * }
 */
/*
 * class Solution {
 * public TreeNode createBinaryTree(int[][] descriptions) {
 * TreeNode[] map = new TreeNode[100001];
 * boolean[] child = new boolean[100001];
 * for (int[] d : descriptions){
 * if (map[d[0]] == null) map[d[0]] = new TreeNode(d[0]);
 * TreeNode node = (map[d[1]] == null ? new TreeNode(d[1]) : map[d[1]]);
 * if (d[2] == 1) map[d[0]].left = node;
 * else map[d[0]].right = node;
 * map[node.val] = node;
 * child[d[1]] = true;
 * }
 * for (int[] d : descriptions)
 * if (!child[d[0]])
 * return map[d[0]];
 * return null;
 * }
 * }
 */