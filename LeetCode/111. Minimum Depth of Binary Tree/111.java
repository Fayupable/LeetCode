/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = initializeQueue(root);
        return performBFS(queue);
    }

    // Function to initialize the queue for BFS
    private Queue<TreeNode> initializeQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        return queue;
    }

    // Function to perform BFS and find the minimum depth
    private int performBFS(Queue<TreeNode> queue) {
        int depth = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                if (isLeafNode(currentNode)) {
                    return depth;
                }
                addChildrenToQueue(currentNode, queue);
            }
            depth++;
        }
        return depth; // This line will never be reached
    }

    // Function to check if a node is a leaf node
    private boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // Function to add the children of a node to the queue
    private void addChildrenToQueue(TreeNode node, Queue<TreeNode> queue) {
        if (node.left != null) {
            queue.offer(node.left);
        }
        if (node.right != null) {
            queue.offer(node.right);
        }
    }
}