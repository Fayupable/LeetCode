/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public TreeNode BalanceBST(TreeNode root) {
        List<int> list = new List<int>();
        
        // Perform inorder traversal to get sorted elements
        Inorder(root, list);
        
        // Build balanced BST from sorted elements
        return BuildBalancedBST(list, 0, list.Count - 1);
    }

    private void Inorder(TreeNode root, List<int> list) {
        if (root == null) return;
        
        Inorder(root.left, list);  // Traverse left subtree
        list.Add(root.val);        // Add root value
        Inorder(root.right, list); // Traverse right subtree
    }

    private TreeNode BuildBalancedBST(List<int> list, int start, int end) {
        if (start > end) return null;
        
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list[mid]);
        
        root.left = BuildBalancedBST(list, start, mid - 1); // Build left subtree
        root.right = BuildBalancedBST(list, mid + 1, end);  // Build right subtree
        
        return root;
    }
}

/*
public class Solution {
    List<TreeNode> list = new List<TreeNode>();
    public TreeNode BalanceBST(TreeNode root) {
        InOrder(root);
        if (list.Count <= 2)
            return root;
        return BuildTree(0, list.Count-1);
        
    }

    private TreeNode BuildTree(int l, int r) {
        if(l>r)
            return null;
        
        var m = l+(r-l)/2;
        var root = list[m];

        root.left = BuildTree(l, m-1);
        root.right = BuildTree(m+1, r);
        return root;
    }

    private void InOrder(TreeNode root) {
        if(root == null)
            return;
        InOrder(root.left);
        list.Add(root);
        InOrder(root.right);
    }


}
*/
/*
public class Solution {
    List<int> nodes = new List<int>();
    public TreeNode BalanceBST(TreeNode root) {
        PopulateNodes(root);
        return CreateTree(nodes, 0, nodes.Count-1);
    }

    private void PopulateNodes(TreeNode root){
        if(root==null) return;
        PopulateNodes(root.left);
        nodes.Add(root.val);
        PopulateNodes(root.right);
    }

    private TreeNode CreateTree(List<int> nodes, int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nodes[mid]);
        root.left = CreateTree(nodes, start, mid-1);
        root.right = CreateTree(nodes, mid+1, end);
        return root;
    }
}
*/