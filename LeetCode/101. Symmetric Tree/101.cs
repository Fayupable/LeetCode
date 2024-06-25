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
    public bool IsSymmetric(TreeNode root) {
        // if root is null, return true
        return IsMirror(root, root);
        
    }
    public bool IsMirror(TreeNode t1, TreeNode t2){
        // if both are null, return true
        if(t1 == null && t2 == null) return true;
        // if one of them is null, return false
        if(t1 == null || t2 == null) return false;
        // if both are not null, check if their values are equal and their children are mirror
        return (t1.val == t2.val) && IsMirror(t1.right, t2.left) && IsMirror(t1.left, t2.right);
    }
}
//other people's solution

/*
public class Solution {
    public bool IsSymmetric(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null || root.right == null)
            return(root.left == null && root.right == null);

        return(CheckLeftToRight(root.left, root.right));       
    }

    public bool CheckLeftToRight(TreeNode left, TreeNode right){
        if(left == null || right == null)
            return(left == null && right == null);
        if(left.val != right.val)
            return false;
        return(CheckLeftToRight(left.left, right.right) && CheckLeftToRight(left.right, right.left));
    }
}
*/
/*
public class Solution {
    public bool IsSymmetric(TreeNode root) {
        return Traverse(root.left, root.right);
    }
    
    bool Traverse(TreeNode left, TreeNode right)
    {
        if(left is null && right is null)
            return true;
        
        if(left is null || right is null || left.val != right.val)
            return false;
        
        var leftEq = Traverse(left.left, right.right);
        
        if(!leftEq)
            return false;
        
        var rightEq = Traverse(left.right, right.left);
        
        return rightEq;
    }
}
*/

/*
public class Solution {
    public bool IsSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        else{
            if(root.left == root.right){
                return true;
            }
                return taraflar(root.left, root.right);
        }

    }
    private bool taraflar(TreeNode left , TreeNode right) {
        if (left == null && right == null)
        {
            return true;
        }

        if (left == null || right == null)
        {
            return false;
        }

        return (left.val == right.val) &&
               taraflar(left.left, right.right) &&
               taraflar(left.right, right.left);
    }
}
*/