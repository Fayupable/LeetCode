public class MyClass404 {
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
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeft(root,false);
        
    }
    private int sumOfLeft(TreeNode node,boolean isLeft){
        //if node is null, return 0
        if(node==null){
            return 0;
        }
        if(node.left==null&&node.right==null){
            //check current node
            if(isLeft){
                //if its a left leaf, return val
                return node.val;
            }else{
                //not left leaf, return 0
                return 0;
            }
        }
        int leftSum=sumOfLeft(node.left,true);
        int rightSum=sumOfLeft(node.right,false);
        return leftSum+rightSum;
    }
}

    
}
