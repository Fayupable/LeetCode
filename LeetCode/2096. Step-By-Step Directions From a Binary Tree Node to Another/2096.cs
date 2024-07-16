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
    public string GetDirections(TreeNode root, int startValue, int destValue) {
        // First, find the LCA of startValue and destValue
        TreeNode lca = LCA(root, startValue, destValue);

        // Get path from LCA to startValue and destValue
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        GetPath(lca, startValue, pathToStart);
        GetPath(lca, destValue, pathToDest);

        // Reverse the path to start since we need to move upwards from start to LCA
        string upwardPath = new string('U', pathToStart.Length);

        // Both paths are collected in reverse order because of the nature of recursion
        // They need to be reversed to be used correctly
        char[] startPath = pathToStart.ToString().ToCharArray();
        Array.Reverse(startPath);
        char[] destPath = pathToDest.ToString().ToCharArray();
        Array.Reverse(destPath);

        // Convert movements from start to LCA into 'U's and then add movements from LCA to dest
        return upwardPath + new string(destPath);
    }

    private TreeNode LCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (left != null && right != null) return root;
        return left ?? right;
    }

    private bool GetPath(TreeNode node, int val, StringBuilder path) {
        if (node == null) return false;
        if (node.val == val) return true;

        // Try to find the path in the left or right subtree
        if (GetPath(node.left, val, path)) {
            path.Append('L'); // Append 'L' if the path is found in the left subtree
        } else if (GetPath(node.right, val, path)) {
            path.Append('R'); // Append 'R' if the path is found in the right subtree
        } else {
            return false; // If no path found, return false
        }

        return true;
    }
}

/*
public class Solution {
    public string GetDirections(TreeNode root, int startValue, int destValue) {
        List<TreeNode> sourcePath = new List<TreeNode>();
        List<TreeNode> destPath = new List<TreeNode>();
        GetPath(root, startValue, sourcePath);
        GetPath(root, destValue, destPath);
        sourcePath.Reverse();
        destPath.Reverse();

        int i=0;
        while(i<sourcePath.Count || i<destPath.Count){
            if(sourcePath[i].val != destPath[i].val){
                i--;
                break;
            }
            if(i == sourcePath.Count-1 || i == destPath.Count-1){
                break;
            }
            i++;
        }

        int sourceLen = sourcePath.Count-i-1;
        string shortestPath = "";
        StringBuilder sb = new StringBuilder("");
        int j=sourceLen;
        while(j>0){
            sb.Append("U");
            j--;
        }
        TreeNode prev = destPath[i], curr;
        for(int k=i+1;k<destPath.Count;k++){
            curr = destPath[k];
            if(prev.left == curr){
                sb.Append("L");
            }
            else{
                sb.Append("R");
            }
            prev = curr;
        }
        return sb.ToString();
    }

    public bool GetPath(TreeNode root, int target, List<TreeNode> path){
        if(root == null){
            return false;
        }
        if(root.val == target){
            path.Add(root);
            return true;
        }
        if(GetPath(root.left, target, path) || GetPath(root.right, target,path)){
            path.Add(root);
            return true;
        }
        return false;
    }
}
*/

/*
public class Solution {
    public string GetDirections(TreeNode root, int startValue, int destValue) 
    {
        var startPath = new List<char>();
        var destPath = new List<char>();

        if (!FindPath(root, startValue, startPath) || !FindPath(root, destValue, destPath))
            return string.Empty;

        int i = 0;
        while (i < startPath.Count && i < destPath.Count && startPath[i] == destPath[i])
            i++;

        var result = new StringBuilder();
        for (int j = i; j < startPath.Count; j++)
            result.Append('U');
        
        for (int j = i; j < destPath.Count; j++)
            result.Append(destPath[j]);

        return result.ToString();
    }

    private bool FindPath(TreeNode root, int value, List<char> path)
    {
        if (root == null) return false;
        if (root.val == value) return true;

        path.Add('L');
        if (FindPath(root.left, value, path)) return true;
        path.RemoveAt(path.Count - 1);

        path.Add('R');
        if (FindPath(root.right, value, path)) return true;
        path.RemoveAt(path.Count - 1);

        return false;
    }
        
        /*
        StringBuilder startPath = new();
        StringBuilder destinationPath = new();
        
        GetPath(root, startValue, startPath);
        GetPath(root, destValue, destinationPath);
        
        startPath = new StringBuilder(new string(startPath.ToString().Reverse().ToArray()));
        destinationPath = new StringBuilder(new string(destinationPath.ToString().Reverse().ToArray()));
        
        while (startPath.Length > 0 && destinationPath.Length > 0 && startPath[0] == destinationPath[0]) {
            startPath.Remove(0, 1);
            destinationPath.Remove(0, 1);
        }
        
        for (int i = 0; i < startPath.Length; ++i) {
            if (startPath[i] == 'L' || startPath[i] == 'R'){ 
                startPath[i] = 'U';
            }
        }
        
        return startPath.ToString() + destinationPath.ToString();
    }
    
    public bool GetPath(TreeNode r, int v, StringBuilder p) {
        if (r.val == v) {
            return true;
        } else if (r.left != null && GetPath(r.left, v, p)) {
            p.Append("L");
            return true;
        } else if (r.right != null && GetPath(r.right, v, p)) {
            p.Append("R");
            return true;
        } else {
            return false;
        }
    }
    */

*/