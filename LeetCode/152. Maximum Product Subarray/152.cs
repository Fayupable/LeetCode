public class Solution {
    public int MaxProduct(int[] nums) {
        if (nums.Length == 0){
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.Length; i++) {
            int current = nums[i];

            int temp_max = Math.Max(current, Math.Max(max * current, min * current));
            int temp_min = Math.Min(current, Math.Min(max * current, min * current));

            max = temp_max;
            min = temp_min;

            result = Math.Max(result, max);
        }

        return result;
    }

}

/*
public class Solution {
    public int MaxProduct(int[] nums) {

        int suffix = 1;
        int prefix = 1;
        int n = nums.Length;
        int ans = int.MinValue;

        for(int i = 0; i < n; i++){

            if(prefix == 0){
                prefix = 1;
            }

            if(suffix == 0){
                suffix = 1;
            }

            prefix *= nums[i];
            suffix *= nums[n-i-1];

            ans = Math.Max(ans, Math.Max(prefix, suffix));
        }

        return ans;
    }
}
*/
/*
public class Solution {
    public int MaxProduct(int[] nums)
    {
            double[] minP = new double[nums.Length + 1], maxP = new double[nums.Length + 1];
            int res = int.MinValue;
            minP[0] = 1;
            maxP[0] = 1;
            for (int i = 0; i < nums.Length; ++i)
            {
                var nextMin = (minP[i] != 0 ? minP[i] : 1) * nums[i];
                var nextMax = (maxP[i] != 0 ? maxP[i] : 1) * nums[i];
                minP[i + 1] = Math.Min(Math.Min(nextMin, nextMax), nums[i]);
                maxP[i + 1] = Math.Max(Math.Max(nextMin, nextMax), nums[i]);

                res = Math.Max(res, (int)maxP[i + 1]);
            }

            return res;
    }
    
    public int MaxProductV3(int[] nums)
    {
        double product = 1, res = int.MinValue;
        for(int i = 0; i < nums.Length; ++i)
        {
            product *= nums[i];
            res = Math.Max(product, res);
            if (product == 0)
                product = 1;
        }
        
        product = 1;
        for(int i = nums.Length - 1; i >= 0; --i)
        {
            product *= nums[i];
            res = Math.Max(res, product);
            if (product == 0)
                product = 1;
        }
        
        return (int)res;
    }
    
    public int MaxProductV2(int[] nums) {
        // dp[i, 0] is the max product ends by i
        // dp[i, 1] is the min product ends by i
        int[] dp = new int[2];
        dp[0] = dp[1] = nums[0]; // base case
        int maxProduct = nums[0];
        for(int i = 1; i < nums.Length; ++i)
        {
            int product1 = nums[i] * dp[0];
            int product2 = nums[i] * dp[1];
            dp[0] = Math.Max(nums[i], Math.Max(product1, product2));
            dp[1] = Math.Min(nums[i], Math.Min(product1, product2));
            
            maxProduct = Math.Max(maxProduct, dp[0]);
        }
        
        return maxProduct;
    }
    
    public int MaxProductV1(int[] nums) {
        // dp[i, 0] is the max product ends by i
        // dp[i, 1] is the min product ends by i
        int[,] dp = new int[nums.Length, 2];
        dp[0, 0] = dp[0, 1] = nums[0]; // base case
        int maxProduct = nums[0];
        for(int i = 1; i < nums.Length; ++i)
        {
            int product1 = nums[i] * dp[i - 1, 0];
            int product2 = nums[i] * dp[i - 1, 1];
            dp[i, 0] = Math.Max(nums[i], Math.Max(product1, product2));
            dp[i, 1] = Math.Min(nums[i], Math.Min(product1, product2));
            
            maxProduct = Math.Max(maxProduct, dp[i, 0]);
        }
        
        return maxProduct;
    }
}
*/
/*
public class Solution {
    public int MaxProduct(int[] nums) {
        int maxProduct=nums[0], l=1, r=1;
        for(int i=0;i<nums.Length;i++){
            l=(l==0?1:l)*nums[i];
            r=(r==0?1:r)*nums[nums.Length-1-i];
            maxProduct=Math.Max(maxProduct, Math.Max(l,r));
        }
        return maxProduct;
    }
}
*/
/*
public class Solution {
    public int MaxProduct(int[] nums) {
       var maxProduct = 0;
        var leftProduct = 1;
        var rightProduct = 1;
        var length = nums.Length;
        if (length == 1) return nums[0];
        for (int i = 0; i < nums.Length; i++)
        {
            if (leftProduct == 0)
            {
                leftProduct = 1;
            }
            leftProduct = leftProduct * nums[i];
            if (leftProduct > 1492992000 || leftProduct < -1492992000)
            {
                leftProduct = 1;
            }
            if (rightProduct == 0)
            {
                rightProduct = 1;
            }
            rightProduct = rightProduct * nums[length - 1 - i];
            if (rightProduct > 1492992000 || rightProduct < -1492992000)
            {
                rightProduct = 1;
            }
            var t = Math.Max(leftProduct, rightProduct);
            maxProduct = t > maxProduct ? t : maxProduct;
            maxProduct = maxProduct > 1492992000 ? 1492992000 : maxProduct;
        }
        return maxProduct;
    }
}
*/
/*
public class Solution {
    public int MaxProduct(int[] nums) {
        if (nums == null || nums.Length == 0) return 0;
            int min, max, res;
            min = max = res = nums[0];

            for (int i = 1; i < nums.Length; i++)
            {
                int[] iteration = new int[] { nums[i] * min, nums[i] * max, nums[i] };
                max = iteration.Max();
                min = iteration.Min();
                res = Math.Max(res, max);
            }
            return res;
    }
}
*/
