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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Find LCA of startValue and destValue
        TreeNode lca = findLCA(root, startValue, destValue);

        // Find the path from LCA to startValue and destValue
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);

        // Convert pathToStart to 'U's because we are moving up from start to LCA
        for (int i = 0; i < pathToStart.length(); i++) {
            pathToStart.setCharAt(i, 'U');
        }

        // The answer is the path moving up from start to LCA and then down to
        // destination
        pathToStart.reverse();
        return pathToStart.toString() + pathToDest.toString();
    }

    private boolean findPath(TreeNode root, int val, StringBuilder path) {
        if (root == null)
            return false;
        if (root.val == val)
            return true;

        path.append('L');
        if (findPath(root.left, val, path))
            return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPath(root.right, val, path))
            return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    private TreeNode findLCA(TreeNode root, int startValue, int destValue) {
        if (root == null || root.val == startValue || root.val == destValue)
            return root;

        TreeNode left = findLCA(root.left, startValue, destValue);
        TreeNode right = findLCA(root.right, startValue, destValue);

        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }
}

/*
 * class Solution {
 * static byte[] path = new byte[200_001];
 * int strtLevel = -1;
 * int destLevel = -1;
 * int comnLevel = -1;
 * 
 * public String getDirections(TreeNode root, int startValue, int destValue) {
 * findPaths(root, startValue, destValue, 100_000);
 * int answerIdx = comnLevel;
 * for (int i = strtLevel; i > comnLevel; i--)
 * path[--answerIdx] = 'U';
 * return new String(path, answerIdx, destLevel - answerIdx);
 * }
 * 
 * private int findPaths(TreeNode node, int strtVal, int destVal, int level) {
 * if (node == null) return 0;
 * int result = 0;
 * if (node.val == strtVal) {
 * strtLevel = level;
 * result = 1;
 * } else if (node.val == destVal) {
 * destLevel = level;
 * result = 1;
 * }
 * int leftFound = 0;
 * int rightFound = 0;
 * if (comnLevel < 0) {
 * if (destLevel < 0) path[level] = 'L';
 * leftFound = findPaths(node.left, strtVal, destVal, level + 1);
 * rightFound = 0;
 * if (comnLevel < 0) {
 * if (destLevel < 0) path[level] = 'R';
 * rightFound = findPaths(node.right, strtVal, destVal, level + 1);
 * }
 * }
 * if (comnLevel < 0 && leftFound + rightFound + result == 2)
 * comnLevel = level;
 * return result | leftFound | rightFound;
 * }
 * }
 */
/*
 * class Solution {
 * String s1,s2;
 * public String getDirections(TreeNode root, int startValue, int destValue) {
 * s1="";
 * s2="";
 * 
 * getCode(root,startValue,destValue,new StringBuilder());
 * // System.out.println(s1+"    "+s2);
 * 
 * int lca=lca(s1,s2);
 * // System.out.println("lca="+lca);
 * 
 * s1=s1.substring(lca,s1.length());
 * s2=s2.substring(lca,s2.length());
 * 
 * // System.out.println(s1+"    "+s2);
 * 
 * s1=s1.replace("R","U");
 * s1=s1.replace("L","U");
 * return s1+s2;
 * }
 * 
 * int lca(String s1, String s2){
 * int n = Math.min(s1.length(),s2.length());
 * int i=0;
 * while(i<n && s1.charAt(i)==s2.charAt(i)){
 * i++;
 * }
 * return i;
 * }
 * 
 * void getCode(TreeNode root, int val1, int val2, StringBuilder sb) {
 * if (root == null) {
 * return;
 * }
 * 
 * if (root.val == val1) {
 * s1 = sb.toString();
 * }
 * if(root.val == val2) {
 * s2 = sb.toString();
 * }
 * 
 * sb.append("L");
 * getCode(root.left, val1, val2, sb);
 * sb.deleteCharAt(sb.length()-1);
 * 
 * sb.append("R");
 * getCode(root.right, val1, val2, sb);
 * sb.deleteCharAt(sb.length()-1);
 * }
 * }
 */