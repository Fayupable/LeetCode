class Solution
{
public:
    //int maximumImportance(int n, vector<vector<int>> &roads)
    long long maximumImportance(int n, vector<vector<int>> &roads)
    {
        // Count the number of connections for each city
        vector<int> connectionCounts(n, 0);
        for (auto &road : roads)
        {
            // Increment the connection count for both cities
            connectionCounts[road[0]]++;
            connectionCounts[road[1]]++;
        }
        // Sort the connection counts in descending order
        sort(connectionCounts.begin(), connectionCounts.end(), greater<int>());
        // Calculate the total importance
        long long totalImportance = 0;
        // The importance of the first city is the sum of all connections
        for (int i = 0; i < n; ++i)
        {
            // The importance of the city is the number of connections times the distance from the city
            totalImportance += static_cast<long long>(connectionCounts[i]) * (n - i);
        }

        return totalImportance;
    }
};
//other peoples solution
/*
class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        ios::sync_with_stdio(false);
        cin.tie(nullptr);
        cout.tie(nullptr);
        
        vector<long long> deg(n);
        for (auto& v : roads) for (int n : v) deg[n]++;
        sort(deg.begin(), deg.end());

        long long ret = 0;
        for (long long i = 1; i <= n; ++i) ret += i * deg[i - 1];
        return ret;
    }
};
*/
/*
class Solution {
public:
    long long maximumImportance(int n, vector<vector<int>>& roads) {
        long ans = 0;
            vector<long> count(n);

                for (const vector<int>& road : roads) {
                      const int u = road[0];
                            const int v = road[1];
                                  ++count[u];
                                        ++count[v];
                                            }

                                                ranges::sort(count);

                                                    for (int i = 0; i < n; ++i)
                                                          ans += (i + 1) * count[i];

                                                              return ans;
    }
};
*/