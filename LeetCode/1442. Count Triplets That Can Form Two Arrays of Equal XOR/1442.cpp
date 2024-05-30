class Solution {
public:
    int countTriplets(vector<int>& arr) {
        // Get the size of the array
        int n = arr.size();
        // Initialize prefix and count variables
        int prefix = 0;
        int count = 0;
        // Create unordered_maps for prefixCount and prefixSum
        unordered_map<int,int> prefixCount;
        unordered_map<int,int> prefixSum;

        // Initialize prefixCount and prefixSum for prefix 0
        prefixCount[0] = 1;
        prefixSum[0] = 0;

        // Iterate over the array
        for(int i = 0; i < n; i++){
            // Update prefix with bitwise XOR of current array element
            prefix ^= arr[i];
            // If prefix is in prefixCount, update count
            if(prefixCount.find(prefix) != prefixCount.end()){
                count += prefixCount[prefix] * i - prefixSum[prefix];
            }
            // Update prefixCount and prefixSum for current prefix
            prefixCount[prefix] += 1;
            prefixSum[prefix] += (i + 1);
        }
        // Return the count
        return count;
    }
};

/*
class Solution {
public:
    int countTriplets(vector<int>& A) {
        A.insert(A.begin(), 0);
        int n = A.size(), res = 0;
        for (int i = 1; i < n; ++i)
            A[i] ^= A[i - 1];
        for (int i = 0; i < n; ++i)
            for (int j = i + 1; j < n; ++j)
                if (A[i] == A[j])
                    res += j - i - 1;
        return res;
    }
};
*/
/*
class Solution {
public:
    int countTriplets(vector<int>& arr) {
        vector<int> prefixXOR(arr.begin(), arr.end());
        prefixXOR.insert(prefixXOR.begin(), 0);
        int size = prefixXOR.size();
        int count = 0;

        // Performing XOR operation on the array elements
        for (int i = 1; i < size; ++i) prefixXOR[i] ^= prefixXOR[i - 1];

        // Maps to store counts and totals of XOR values encountered
        unordered_map<int, int> countMap, totalMap;

        // Iterating through the array
        for (int i = 0; i < size; ++i) {
            // Calculating contribution of current element to the result
            count +=
                countMap[prefixXOR[i]]++ * (i - 1) - totalMap[prefixXOR[i]];

            // Updating total count of current XOR value
            totalMap[prefixXOR[i]] += i;
        }

        return count;
    }
};
*/
/*
class Solution {
public:
    int countTriplets(vector<int>& arr) {
        int c=0;
        for(int i=0;i<arr.size();i++)
        {
            int x=arr[i];
            for(int k=i+1;k<arr.size();k++)
            {
                x=x^arr[k];
                if(x==0)
                {
                    c+=k-i;
                }
            }
        }
        return c;
    }
};
*/