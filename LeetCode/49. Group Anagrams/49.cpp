#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        // Create a map to store sorted character sequences as keys and lists of anagrams as values
        unordered_map<string, vector<string>> anagrams;
        
        for (const string& word : strs) {
            // Sort the word to create the key
            string sorted_word = word;
            sort(sorted_word.begin(), sorted_word.end());
            
            // Add the word to the corresponding anagram group in the map
            anagrams[sorted_word].push_back(word);
        }
        
        // Collect all the anagram groups
        vector<vector<string>> result;
        for (auto& pair : anagrams) {
            result.push_back(pair.second);
        }
        
        return result;
    }
};

//Other people's solution
/*
class Solution {
 public:
  vector<vector<string>> groupAnagrams(vector<string>& strs) {
    vector<vector<string>> ans;
    unordered_map<string, vector<string>> keyToAnagrams;

    for (const string& str : strs) {
      string key = str;
      ranges::sort(key);
      keyToAnagrams[key].push_back(str);
    }

    for (const auto& [_, anagrams] : keyToAnagrams)
      ans.push_back(anagrams);

    return ans;
  }
};
*/
/*
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> anagramMap;

   
        for (string s : strs) {
            string sortedStr = s;
            sort(sortedStr.begin(), sortedStr.end());
            anagramMap[sortedStr].push_back(s);
        }

   
        vector<vector<string>> output;
        for (auto& pair : anagramMap) {
            output.push_back(pair.second);
        }

        return output;
    }
};
*/
/*
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        int n=strs.size();
        vector<vector<string>> result;
        unordered_map<string, vector<string>>hash;
        for(int i=0; i<n; i++){
            string curr=strs[i];
            sort(curr.begin(), curr.end());
            hash[curr].push_back(strs[i]);
        }
        for(auto &itr:hash){
            result.push_back(itr.second);
        }
        return result;
    }
};
*/

/*
#include <vector>
#include <unordered_map>
#include <algorithm>

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& words) {
        // Unordered map to store anagram groups
        unordered_map<string, vector<string>> anagramGroups;
        
        // Iterate through each word in the input vector
        for (const string& word : words) {
            // Sort the characters in the word to create a key
            string key = word;
            sort(key.begin(), key.end());
            
            // If key is not in the map, add a new entry with the word as a vector
            if (anagramGroups.find(key) == anagramGroups.end()) {
                anagramGroups[key] = {word};
            }
            // If key is already present, append the word to the existing vector
            else {
                anagramGroups[key].push_back(word);
            }
        }
        
        // Convert map values to a vector and return
        vector<vector<string>> result;
        for (const auto& group : anagramGroups) {
            result.push_back(group.second);
        }
        
        return result;
    }
};
*/
/*
#include <vector>
#include <array>
#include <string>
#include <unordered_map>
#include <iostream>

using namespace std;

class Solution
{
public:
    struct ArrayHasher
    {
        std::size_t operator()(const std::array<char, 26> &a) const
        {
            std::size_t h = 0;

            for (auto e : a)
            {
                h ^= std::hash<char>{}(e) + 0x9e3779b9 + (h << 6) + (h >> 2);
            }
            return h;
        }
    };

    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        unordered_map<array<char, 26>, vector<string>, ArrayHasher> anagramGroups{};
        for (const string &str : strs)
        {
            array<char, 26> charCounts{};
            for (const char i : str)
            {
                ++charCounts[i - 'a'];
            }
            anagramGroups[std::move(charCounts)].push_back(str);
        }
        vector<vector<string>> ans{};
        ans.reserve(anagramGroups.size());
        for (auto& [_, group] : anagramGroups)
        {
            // group.shrink_to_fit();
            ans.emplace_back(std::move(group));
        }

        return ans;
    }
};

class Solution2
{
public:
    // Doesn't work since hashing requires the elements in order
    // Best option is to hash each individual component
    // Then sort the hashes lexically
    // Then combine and hash again
    struct MapHasher
    {
        std::size_t operator()(const unordered_map<char, char> &a) const
        {
            std::size_t h = 0;

            for (const auto [i, cnt] : a)
            {
                h ^= std::hash<char>{}(i) + 0x9e3779b9 + (h << 6) + (h >> 2);
                h ^= std::hash<char>{}(cnt) + 0x9e3779b9 + (h << 5) + (h >> 3);
            }
            return h;
        }
    };

    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        unordered_map<unordered_map<char, char>, vector<string>, MapHasher> anagramGroups{};
        for (const string &str : strs)
        {
            unordered_map<char, char> charCounts{};
            for (const char i : str)
            {
                ++charCounts[i];
            }
            cout << '[';
            for (const auto [i, cnt] : charCounts)
                cout << i << ':' << static_cast<int>(cnt) << ',';
            cout << ']';
            cout << MapHasher()(charCounts) << '\n';
            anagramGroups[charCounts].push_back(str);
        }
        vector<vector<string>> ans{};
        ans.reserve(anagramGroups.size());
        for (auto [_, group] : anagramGroups)
            ans.emplace_back(group);

        return ans;
    }
};

class Solution3
{
public:
    vector<vector<string>> groupAnagrams(vector<string> &strs)
    {
        unordered_map<string, vector<string>> m;
        for (int i = 0; i < strs.size(); i++)
        {
            string key = getKey(strs[i]);
            m[key].push_back(strs[i]);
        }

        vector<vector<string>> result;
        for (auto it = m.begin(); it != m.end(); it++)
        {
            result.push_back(it->second);
        }
        return result;
    }

private:
    string getKey(string str)
    {
        vector<int> count(26);
        for (int j = 0; j < str.size(); j++)
        {
            count[str[j] - 'a']++;
        }

        string key = "";
        for (int i = 0; i < count.size(); i++)
        {
            key.append(to_string(count[i]) + '#');
        }
        return key;
    }
};

// class Solution4
// {
// public:
//     template<int S>
//     struct ArrayHasher
//     {
//         size_t operator()(char arr[]) const
//         {
//             size_t h = 0;
//
//             for (size_t i{0}; i < S; ++i)
//             {
//                 h ^= hash<char>{}(arr[i]) + 0x9e3779b9 + (h << 6) + (h >> 2);
//             }
//             return h;
//         }
//     };
//
//     struct ArrayHasher2
//     {
//         std::size_t operator()(const std::array<char, 26> &a) const {
//             string aStr {};
//             for (char c : a)
//             aStr += c;
//             return hash<string>{}(aStr);
//         }
//     };
//
//     vector<vector<string>> groupAnagrams(vector<string> &strs)
//     {
//         unordered_map<char(*)[], vector<string>, ArrayHasher<26>> anagramGroups{};
//         for (const string &str : strs)
//         {
//             char charCounts[26];
//             for (const char i : str)
//             {
//                 ++charCounts[i - 'a'];
//             }
//             anagramGroups[std::move(&charCounts)].push_back(str);
//         }
//         vector<vector<string>> ans{};
//         ans.reserve(anagramGroups.size());
//         for (auto [_, group] : anagramGroups)
//             ans.emplace_back(group);
//
//         return ans;
//     }
// };
*/
/*
class Solution {

 public:

  vector<vector<string>> groupAnagrams(vector<string>& strs) {

    vector<vector<string>> ans;

    unordered_map<string, vector<string>> keyToAnagrams;

    for (const string& str : strs) {

      string key = str;

      ranges::sort(key);

      keyToAnagrams[key].push_back(str);

    }

    for (const auto& [_, anagrams] : keyToAnagrams)

      ans.push_back(anagrams);

    return ans;

  }

};
*/