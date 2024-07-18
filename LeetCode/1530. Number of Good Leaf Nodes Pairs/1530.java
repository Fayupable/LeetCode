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
    public int countPairs(TreeNode root, int distance) {
        int[] res = new int[1];
        dfs(root, distance, res);
        return res[0];

    }

    public List<Integer> dfs(TreeNode root, int distance, int[] res) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            return list;
        }
        List<Integer> left = dfs(root.left, distance, res);
        List<Integer> right = dfs(root.right, distance, res);
        for (int l : left) {
            for (int r : right) {
                if (l + r + 2 <= distance) {
                    res[0]++;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int l : left) {
            if (l + 1 < distance) {
                list.add(l + 1);
            }
        }
        for (int r : right) {
            if (r + 1 < distance) {
                list.add(r + 1);
            }
        }
        return list;
    }
}

/*
 * class Solution {
 * public int countPairs(TreeNode root, int distance) {
 * int[] result= new int[1];
 * dfs(root,distance,result);
 * return result[0];
 * }
 * private int[] dfs(TreeNode node,int distance, int[] result){
 * if(node==null){
 * return new int[distance+1];
 * }
 * if(node.left==null&&node.right==null){
 * int[] leafDistance = new int[distance+1];
 * leafDistance[1]=1;
 * return leafDistance;
 * }
 * 
 * int[] left=dfs(node.left,distance,result);
 * int[] right= dfs(node.right,distance,result);
 * 
 * //calculate result
 * for(int i=1;i<=distance;i++){
 * for(int j=1;j<=distance-i;j++){
 * result[0] += left[i]*right[j];
 * }
 * }
 * 
 * int[] leafDistance = new int[distance+1];
 * for(int i=1;i<distance;i++){
 * leafDistance[i+1]= left[i]+ right[i];
 * }
 * return leafDistance;
 * }
 * }
 */

/*
 * class Solution {
 * int result = 0;
 * public int countPairs(TreeNode root, int distance) {
 * dfs(root,distance);
 * return result;
 * }
 * 
 * int[] dfs(TreeNode root,int distance){
 * if(root == null)
 * return new int[distance+1];
 * if(root.left == null && root.right == null){
 * int res[] = new int[distance+1];
 * res[1]++;
 * return res;
 * }
 * int[] left = dfs(root.left,distance);
 * int[] right = dfs(root.right,distance);
 * for(int l=1;l<left.length;l++){
 * for(int r = distance-1;r>=0;r--){
 * if(l+r <=distance)
 * result += left[l]*right[r];
 * }
 * }
 * int res[] = new int[distance+1];
 * //shift by 1
 * for(int i=res.length-2;i>=1;i--){
 * res[i+1] = left[i]+right[i];
 * }
 * 
 * return res;
 * }
 * }
 */
/*
 * class Solution {
 * public int countPairs(TreeNode root, int distance) {
 * if (root == null) {
 * return 0;
 * }
 * int ans = countPairs(root.left, distance) + countPairs(root.right, distance);
 * int[] cnt1 = new int[distance];
 * int[] cnt2 = new int[distance];
 * dfs(root.left, cnt1, 1);
 * dfs(root.right, cnt2, 1);
 * for (int i = 0; i < distance; ++i) {
 * for (int j = 0; j < distance; ++j) {
 * if (i + j <= distance) {
 * ans += cnt1[i] * cnt2[j];
 * }
 * }
 * }
 * return ans;
 * }
 * 
 * void dfs(TreeNode root, int[] cnt, int i) {
 * if (root == null || i >= cnt.length) {
 * return;
 * }
 * if (root.left == null && root.right == null) {
 * ++cnt[i];
 * return;
 * }
 * dfs(root.left, cnt, i + 1);
 * dfs(root.right, cnt, i + 1);
 * }
 * }
 */

/*
 * class Solution {
 * public int countPairs(TreeNode root, int distance) {
 * if(root == null || distance<1) {
 * return 0;
 * }
 * 
 * Map<Integer, Integer> leftData = getLeafData(root.left);
 * Map<Integer, Integer> rightData = getLeafData(root.right);
 * int count = 0;
 * 
 * for(int leftDis: leftData.keySet()) {
 * for(int rightDis: rightData.keySet()) {
 * if(leftDis+rightDis+2<=distance) {
 * count+= leftData.get(leftDis) * rightData.get(rightDis);
 * }
 * }
 * }
 * 
 * count+= countPairs(root.left, distance);
 * count+= countPairs(root.right, distance);
 * 
 * return count;
 * }
 * 
 * private Map<Integer, Integer> getLeafData(TreeNode node) {
 * Map<Integer, Integer> data = new HashMap<>();
 * if(node == null) {
 * return data;
 * }
 * 
 * if(node.left == null && node.right ==null) {
 * data.put(0,1);
 * return data;
 * }
 * 
 * findLeaf(node.left, 1, data);
 * findLeaf(node.right, 1, data);
 * 
 * return data;
 * }
 * 
 * private void findLeaf(TreeNode node, int distance, Map<Integer, Integer>
 * data) {
 * if(node == null) {
 * return;
 * }
 * 
 * if(node.left == null && node.right == null) {
 * data.put(distance, data.getOrDefault(distance, 0)+1);
 * return;
 * }
 * 
 * if(node.left !=null) {
 * findLeaf(node.left, distance+1, data);
 * }
 * 
 * if(node.right != null) {
 * findLeaf(node.right, distance+1, data);
 * }
 * }
 * }
 */