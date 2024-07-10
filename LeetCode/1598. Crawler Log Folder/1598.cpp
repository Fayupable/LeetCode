class Solution {
public:
    int minOperations(vector<string>& logs) {
        int depth = 0;
        for (string log : logs) {
            if (log == "../") {
                if (depth > 0) {
                    depth--;
                }
            } else if (log != "./") {
                depth++;
            }
        }
        return depth;
        
    }
};

//with stack
/*
#include <vector>
#include <string>
#include <stack>

class Solution {
public:
    int minOperations(std::vector<std::string>& logs) {
        std::stack<std::string> folderStack;
        for (const std::string& log : logs) {
            if (log == "../") {
                if (!folderStack.empty()) {
                    folderStack.pop();
                }
            } else if (log != "./") {
                folderStack.push(log);
            }
        }
        return folderStack.size();
    }
};
*/

//with queue
/*
#include <vector>
#include <string>
#include <queue>

class Solution {
public:
    int minOperations(std::vector<std::string>& logs) {
        std::queue<std::string> folderQueue;
        int depth = 0;
        for (const std::string& log : logs) {
            if (log == "../") {
                if (depth > 0) {
                    depth--;
                    
                }
            } else if (log != "./") {
                depth++;
                folderQueue.push(log);
            }
        }
        return depth;
    }
};
*/

// other people's solution

/*
class Solution {
public:
    int minOperations(vector<string>& logs) {
        int n = 0;
        for (int i = 0; i < logs.size(); i++) {
            if (logs[i] == "../") {
               if(n>0) n--;
            } else if (logs[i] == "./") {
                continue;
            } else {
                n++;
            }
        }
        if(n<0) return 0;
        return n;
    }
};
*/
/*
class Solution {
public:
    int minOperations(vector<string>& logs) {
        stack<string> s;
        for(string i:logs){
            if(i=="./") continue;
            else if(i=="../"){
                if(s.size()!=0) s.pop();
            }
            else{
                s.push(i);
            }
        }
        return s.size();
    }
};
*/