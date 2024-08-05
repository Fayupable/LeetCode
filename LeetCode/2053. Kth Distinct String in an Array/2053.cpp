class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) {
        // Step 1: Count occurrences of each string
        unordered_map<string, int> countMap = countOccurrences(arr);

        // Step 2: Collect distinct strings
        list<string> distinctStrings = collectDistinctStrings(arr, countMap);

        // Step 3: Return the k-th distinct string
        return getKthDistinctString(distinctStrings, k);
    }

private:
    unordered_map<string, int> countOccurrences(const vector<string>& arr) {
        unordered_map<string, int> countMap;
        for (const string& str : arr) {
            countMap[str]++;
        }
        return countMap;
    }

    list<string> collectDistinctStrings(const vector<string>& arr, const unordered_map<string, int>& countMap) {
        list<string> distinctStrings;
        for (const string& str : arr) {
            if (countMap.at(str) == 1) {
                distinctStrings.push_back(str);
            }
        }
        return distinctStrings;
    }

    string getKthDistinctString(const list<string>& distinctStrings, int k) {
        if (k > distinctStrings.size()) {
            return "";
        }
        auto it = distinctStrings.begin();
        advance(it, k - 1);
        return *it;
    }
};

/*
class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) {
        unordered_map<string, int> mp;
        string ans = "";

        for(string x : arr) {
            mp[x]++;
        }

        for(auto& s : arr) {
            if(mp[s] == 1 && --k == 0)
                return s;
        }
 
        return "";
    }
};*/