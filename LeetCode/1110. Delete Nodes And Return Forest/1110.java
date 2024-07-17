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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        dfs(root, set, res, true);
        return res;
        
    }

    public TreeNode dfs(TreeNode root, Set<Integer> set, List<TreeNode> res, boolean isRoot) {
        if (root == null) {
            return null;
        }
        boolean deleted = set.contains(root.val);
        if (isRoot && !deleted) {
            res.add(root);
        }
        root.left = dfs(root.left, set, res, deleted);
        root.right = dfs(root.right, set, res, deleted);
        return deleted ? null : root;
    }

}