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
    public int CountPairs(TreeNode root, int distance) {
        int count = 0;
        Dfs(root, distance, ref count);
        return count;
        
    }

    private List<int> Dfs(TreeNode node, int distance, ref int count) {
        if (node == null) {
            return new List<int>();
        }

        if (node.left == null && node.right == null) {
            return new List<int> { 1 };
        }

        var left = Dfs(node.left, distance, ref count);
        var right = Dfs(node.right, distance, ref count);

        foreach (var l in left) {
            foreach (var r in right) {
                if (l + r <= distance) {
                    count++;
                }
            }
        }

        var result = new List<int>();
        foreach (var l in left) {
            if (l + 1 < distance) {
                result.Add(l + 1);
            }
        }

        foreach (var r in right) {
            if (r + 1 < distance) {
                result.Add(r + 1);
            }
        }

        return result;
    }
}

/*
public class Solution {
    public int CountPairs(TreeNode root, int distance) {
        int result = 0;

        Count(root);

        return result;        

        int[] Count(TreeNode node)
        {
            if (node.left == null && node.right == null)
            {
                return new int[] { 1 };
            }

            var left = node.left == null ? null : Count(node.left);
            var right = node.right == null ? null : Count(node.right);

            int[] arr;
            if (left == null || right == null)
            {
                var leaves = left ?? right;
                arr = new int[1 + Math.Min(distance, leaves.Length)];
                for (var i = 0; i < Math.Min(arr.Length - 1, leaves.Length); ++i)
                {
                    arr[i+1] = leaves[i];
                }
            }
            else
            {
                for (var i = 0; i < left.Length; ++i)
                {
                    for (var j = 0; j < right.Length; ++j)
                    {
                        if (i + j + 2 > distance) break;

                        result += (left[i] * right[j]);                        
                    }
                }

                arr = new int[1 + Math.Min(distance, Math.Max(left.Length, right.Length))];
                for (var i = 0; i < Math.Min(left.Length, arr.Length - 1); ++i)
                {
                    arr[i + 1] += left[i];
                }

                for (var i = 0; i < Math.Min(right.Length, arr.Length - 1); ++i)
                {
                    arr[i + 1] += right[i];
                }
            }

            return arr;
        }
    }
}
*/