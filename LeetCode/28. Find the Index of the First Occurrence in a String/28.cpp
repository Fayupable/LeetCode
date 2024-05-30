class Solution {
public:
    int strStr(string haystack, string needle) {
        // Use the find method of the string class to find the first occurrence of needle in haystack
        size_t pos = haystack.find(needle);

        // If find returns a valid position (i.e., needle is found in haystack)
        if(pos != string::npos){
            // Cast the size_t position to int and return it
            return static_cast<int>(pos);
        } else {
            // If needle is not found in haystack, return -1
            return -1;
        }
    }
};