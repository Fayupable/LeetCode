class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        unordered_set<string> deadendSet(deadends.begin(), deadends.end());

        if (deadendSet.count("0000")) {
            return -1;
        }

        queue<string> q;
        q.push("0000");
        unordered_set<string> visited;
        visited.insert("0000");

        int turns = 0;

        while (!q.empty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                string current = q.front();
                q.pop();

                if (current == target) {
                    return turns;
                }

                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        string next = current;
                        next[j] = (next[j] - '0' + k + 10) % 10 + '0';
                        if (visited.count(next) == 0 && deadendSet.count(next) == 0) {
                            visited.insert(next);
                            q.push(next);
                        }
                    }
                }
            }
            turns++;
        }

        return -1;
    }
};