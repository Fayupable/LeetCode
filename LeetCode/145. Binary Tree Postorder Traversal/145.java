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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postOrderTraversal(ans, root);
        return ans;
    }

    private void postOrderTraversal(List<Integer> arr, TreeNode root) {
        if (root != null) {
            postOrderTraversal(arr, root.left);
            postOrderTraversal(arr, root.right);
            arr.add(root.val);
        }
    }
}

/*
 * class Solution {
 * public List<Integer> postorderTraversal(TreeNode root) {
 * List<Integer> result = new ArrayList<>();
 * if (root == null) {
 * return result;
 * }
 * 
 * Stack<TreeNode> stack = new Stack<>();
 * TreeNode current = root;
 * TreeNode lastVisited = null;
 * 
 * while (!stack.isEmpty() || current != null) {
 * current = processLeftSubtree(stack, current);
 * current = processRightSubtree(stack, result, lastVisited, current);
 * lastVisited = updateLastVisited(stack, result, lastVisited);
 * }
 * 
 * return result;
 * }
 * 
 * // Processes the left subtree by pushing nodes onto the stack
 * private TreeNode processLeftSubtree(Stack<TreeNode> stack, TreeNode current)
 * {
 * while (current != null) {
 * stack.push(current);
 * current = current.left;
 * }
 * return current;
 * }
 * 
 * // Checks and moves to the right subtree if needed
 * private TreeNode processRightSubtree(Stack<TreeNode> stack, List<Integer>
 * result, TreeNode lastVisited, TreeNode current) {
 * if (!stack.isEmpty()) {
 * TreeNode peekNode = stack.peek();
 * if (peekNode.right != null && lastVisited != peekNode.right) {
 * current = peekNode.right;
 * }
 * }
 * return current;
 * }
 * 
 * // Updates the last visited node and adds it to the result
 * private TreeNode updateLastVisited(Stack<TreeNode> stack, List<Integer>
 * result, TreeNode lastVisited) {
 * if (!stack.isEmpty()) {
 * TreeNode peekNode = stack.peek();
 * if (peekNode.right == null || lastVisited == peekNode.right) {
 * result.add(peekNode.val);
 * lastVisited = stack.pop();
 * }
 * }
 * return lastVisited;
 * }
 * }
 */