#include <vector>
#include <deque>
#include <iostream>

using namespace std;

class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        // Deques to store the indices of the minimum and maximum values in the window
        deque<int> maxDeque, minDeque;
        int start = 0, maxLength = 0;

        for (int end = 0; end < nums.size(); end++) {
            // Maintain the maxDeque and minDeque
            while (!maxDeque.empty() && nums[maxDeque.back()] <= nums[end]) {
                maxDeque.pop_back();
            }
            while (!minDeque.empty() && nums[minDeque.back()] >= nums[end]) {
                minDeque.pop_back();
            }
            maxDeque.push_back(end);
            minDeque.push_back(end);

            // Ensure the current window satisfies the condition
            while (nums[maxDeque.front()] - nums[minDeque.front()] > limit) {
                // Move the start pointer to the right
                if (maxDeque.front() == start) {
                    maxDeque.pop_front();
                }
                // Move the start pointer to the right
                if (minDeque.front() == start) {
                    minDeque.pop_front();
                }
                start++;
            }

            // Update the maximum length of the subarray
            maxLength = max(maxLength, end - start + 1);
        }

        return maxLength; // Return the size of the longest subarray
    }
};

int main() {
    Solution solution;
    vector<int> nums = {10, 1, 2, 4, 7, 2};
    int limit = 5;
    cout << solution.longestSubarray(nums, limit) << endl; // Expected output: 4
    return 0;
}
//other people's solution
/*
#pragma GCC optimize("O3","unroll-loops")
class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        ios::sync_with_stdio(false);
        cin.tie(0);
        cout.tie(0);
        // if the diff between the max and min element of an subarray < k then all other 
        // elements' diff is also < k
        int n = nums.size();
        if(nums.size()==0)return 0;
        // we will keep queue to track the index of max and min element in current window 
        // q1 will track max and subsequent index value will decrease 
        // q2 will track min and subsequent index value will increase 
        deque<int>q1,q2;   
        int i=0,j=0,ans=0;
        while(j<n){
            // to maintain order - if new element is greater than last element 
            // remove last and insert current element in q1  vice versa for q2
            while(!q1.empty() && nums[q1.back()]<nums[j])q1.pop_back();
            while(!q2.empty() && nums[q2.back()]>nums[j])q2.pop_back();
            q1.push_back(j);
            q2.push_back(j);
            while(!q1.empty() && !q2.empty() &&
             (nums[q1.front()] - nums[j]>limit || nums[j]-nums[q2.front()]>limit)){
                if(nums[q1.front()] - nums[j]>limit){
                    i= max(i,q1.front()+1);
                    q1.pop_front();
                }
                if(nums[j]-nums[q2.front()]>limit){
                    i= max(i,q2.front()+1);
                    q2.pop_front();
                }
             }
            ans=max(ans,j-i+1);
            j++;
        }
        return ans;
    }
};
*/
/*
#define faster ios::sync_with_stdio(0); cin.tie(0); cout.tie(0)
class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        faster;
        deque<int> qmin, qmax;
        int ans = 1;
        int start = 0, end = 0;
        int n = nums.size();
        while(end < n) {
            while(!qmax.empty() && qmax.back() < nums[end]) {
                qmax.pop_back();
            }
            while(!qmin.empty() && qmin.back() > nums[end]) {
                qmin.pop_back();
            }
            qmax.push_back(nums[end]);
            qmin.push_back(nums[end]);
            if(abs(qmin.front() - qmax.front()) <= limit) ans = max(end - start + 1, ans);
            else {
                if(qmin.front() == nums[start]) qmin.pop_front();
                if(qmax.front() == nums[start]) qmax.pop_front();
                start++;
            }   
            end++;
        }
        return ans;
    }
};
*/
/*
class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        int ans = 0;
        int low = 0;
        map<int, int> ordered_map;
        for (int high = 0; high < nums.size(); high++) {
            ordered_map[nums[high]]++;
            while (abs(ordered_map.begin()->first - ordered_map.rbegin()->first) > limit) {
                ordered_map[nums[low]]--;
                if (ordered_map[nums[low]] == 0) {
                    ordered_map.erase(nums[low]);
                }
                low++;
            }
            ans = max(ans, high - low + 1);
        }
        return ans;
    }
};
*/
/*
class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        priority_queue<int> pq;
        priority_queue<int, vector<int>, greater<int>> mpq;
        unordered_map<int, int> h, mh;
        int s = 0, ans = 0;
        for(int i = 0; i < nums.size(); i++) {
            pq.push(nums[i]);
            mpq.push(nums[i]);
            while(pq.top() - mpq.top() > limit) {
                if(pq.top() == nums[s]) {
                    pq.pop();
                } else {
                    h[nums[s]]++;
                }
                if(mpq.top() == nums[s]) {
                    mpq.pop();
                } else {
                    mh[nums[s]]++;
                }
                while(h[pq.top()]) {
                    h[pq.top()]--;
                    pq.pop();
                }
                while(mh[mpq.top()]) {
                    mh[mpq.top()]--;
                    mpq.pop();
                }
                s++;
            }
            ans = max(ans, i - s + 1);
        }
        return ans;
    }
};
*/
/*
class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        multiset<int> ms;
        int left = 0,  answer = 1;
        for(int right = 0; right < nums.size(); right++) {
            ms.insert(nums[right]);

            while(!ms.empty() and *ms.rbegin() - *ms.begin() > limit) { // while maxElement - minElement > limit (invalid subarray)
                ms.erase(ms.find(nums[left]));
                left++;
            }

            answer = max(answer, right - left + 1);
        }

        return answer;
    }
};
*/
/*
class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        int mini = INT_MAX;
        int maxi = INT_MIN;
        int miniIndex = -1;
        int maxiIndex = -1;
        int ans = 1;
        int n = nums.size();
        int i = 0;
        int j = 1;
        maxiIndex = i;
        miniIndex = i;
        maxi = nums[i];
        mini = nums[i];
        multiset<pair<int,int>> ms;
        ms.insert({nums[0],0});
        // auto itBegin = ms.begin();
        // auto itEnd = ms.end();
        while(i < n and j < n){
            // cout<<i<<" "<<j<<endl;
            ms.insert({nums[j],j});
            auto itBegin = ms.begin();
            auto itEnd = ms.end();
            itEnd--;
            int miniIndex = (*itBegin).second;
            int maxiIndex = (*itEnd).second;

            // cout<<miniIndex<<" "<<maxiIndex<<endl;
            if(abs(nums[maxiIndex] - nums[miniIndex]) <= limit)
                ans = max(ans,j - i + 1);
            else{
                int index = min(maxiIndex,miniIndex) + 1;
                if(maxiIndex == miniIndex){
                    ms.erase({nums[maxiIndex],maxiIndex});
                }
                else if(maxiIndex < miniIndex) {
                    for(int k = i;k<=maxiIndex;k++)
                    ms.erase({nums[k],k});
                }
                else {
                    for(int k = i;k<=miniIndex;k++)
                    ms.erase({nums[k],k});
                }
                i = index;
                // cout<<"fk"<<index<<endl;

                
                continue;
            }
            j++;
        }
        return ans;
    }
};
*/
/*
class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        int n = nums.size();
        int ans = 0;
        int i = 0;
        int j = 0;
        multiset<int> s;
        while(j < n){
            s.insert(nums[j]);
            if(*s.rbegin() - *s.begin() > limit){
                s.erase(s.find(nums[i]));
                i++;
            }
            ans = max(ans,j - i + 1);
            j++;
        }
        return ans;
    }
};
*/