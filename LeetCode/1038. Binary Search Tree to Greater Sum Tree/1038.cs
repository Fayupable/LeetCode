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
    private int sum = 0;
    
    public TreeNode BstToGst(TreeNode root) {
        if (root != null) {
            // Traverse the right subtree first
            BstToGst(root.right);
            
            // Update the current node
            sum += root.val;
            root.val = sum;
            
            // Traverse the left subtree
            BstToGst(root.left);
        }
        return root;
    }
}
//other poeples solutions
/*
public class Solution {
    public TreeNode BstToGst(TreeNode root) {
        Recurse(root, 0);
        return root;

        int Recurse(TreeNode node, int add) {
          if (node == null) return 0;
          node.val += Recurse(node.right, add);
          var value = node.val;
          node.val += add;
          return value + Recurse(node.left, node.val);
        }
    }
}
*/
/*
public class Solution {
    List<TreeNode> inorder = new();
    public TreeNode BstToGst(TreeNode root) {
        DFS(root);
        int sum = 0;
        inorder.Reverse();
        foreach(TreeNode node in inorder){
            int newSum = sum + node.val;
            node.val += sum;
            sum = newSum;
        }
        return root;
    }
    public void DFS(TreeNode node){
        if(node == null) return;
        if(node.left != null){         
            DFS(node.left);                     
        } 
        inorder.Add(node);
        if(node.right != null){
           DFS(node.right);
        }     
    }
}
*/