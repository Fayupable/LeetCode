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
    private int sum = 0;
    
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            // Traverse the right subtree first
            bstToGst(root.right);
            
            // Update the current node
            sum += root.val;
            root.val = sum;
            
            // Traverse the left subtree
            bstToGst(root.left);
        }
        return root;
    }
}


// Other people's solution
/*
//Better memory usage
 class Solution {
    int sum = 0;
    public void  helper(TreeNode root)
    {
        if(root == null)
        return;

        helper(root.right);

        sum += root.val;

        root.val = sum;

        helper(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        helper(root);

        return root;
    }
}
 */
/*
 class Solution {
    public TreeNode bstToGst(TreeNode root) {  
        if (root == null)
        {
            return root;
        }
        List<TreeNode> list = new ArrayList<>();
        traversal(root, list);
        int sum = 0;
        for (TreeNode x: list)
        {   
            sum = sum + x.val;
            x.val = sum;
        }
        return root;
    }
        public void traversal(TreeNode root, List<TreeNode>  list)
        {
            if (root.right != null) traversal(root.right, list);
            list.add(root);
            if (root.left != null) traversal(root.left, list);
        }
}
 */