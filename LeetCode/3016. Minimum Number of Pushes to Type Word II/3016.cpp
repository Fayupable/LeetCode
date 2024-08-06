class Solution {
public:
    static int minimumPushes(string& word) {
        int freq[26]={0};
        for(char c: word) 
            freq[c-'a']++;
        sort(freq, freq+26);
    
        int sz=25, ans=0;
        for(; sz>=0 && freq[sz]!=0; sz--){
            ans+=freq[sz]*((25-sz)/8+1);    
        }
        return ans;
    }
};

/*
#include <execution>
auto f = [] {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    return 0;
}();
class Solution {
public:
    int minimumPushes(string word) {
        array<int, 26> f {};
        for (char c : word) {
            f[c - 'a']++;
        }
        sort(execution::par_unseq, f.begin(), f.end(), greater{});
        return transform_reduce(execution::par_unseq, f.begin(), f.end(), 0, plus{}, [f = &f[0]](int const& x) { 
            int i = &x - f;
            return x * (i / 8 + 1);
        });
    }
};
*/

/*
class Solution {
public:
    static int minimumPushes(string& word) {
        int freq[26]={0};
        for(char c: word) 
            freq[c-'a']++;
        sort(freq, freq+26);
    
        int sz=25, ans=0;
        for(; sz>=0 && freq[sz]!=0; sz--){
            ans+=freq[sz]*((25-sz)/8+1);    
        }
        return ans;
    }
};
*/

/*
class Solution {
public:
    void print(auto& c){
        for(int x: c) cout<<x<<", "; 
        cout<<endl;
    }
    int minimumPushes(string& word) {
        int freq[26]={0};
    //    memset(freq, 0, sizeof(freq));
        for(char c: word) 
            freq[c-'a']++;
        sort(freq, freq+26, greater<int>());
    //    print(freq);
        int sz=0, push=1, ans=0;
        for(; sz<26 && freq[sz]!=0; sz++){
            if (sz>=8 && sz%8==0) push++;
            ans+=freq[sz]*push;    
        }
        return ans;
    }
};

auto init = []()
{ 
    ios::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    return 'c';
}();
*/