class Solution
{
public:
    double averageWaitingTime(vector<vector<int>> &customers)
    {
        double waitTime = 0;
        double currentTime = 0;
        for (int i = 0; i < customers.size(); i++)
        {
            currentTime = max(currentTime, (double)customers[i][0]);
            currentTime += customers[i][1];
            waitTime += currentTime - customers[i][0];
        }
        return waitTime / customers.size();
    }
};
//other people's solution
/*
class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
        double ans = 0 ;
        int prev = 0 ;
        for(int i =  0; i < customers.size();i++){
            if(prev <= customers[i][0]){
               ans += customers[i][1] ; prev = customers[i][1]  +  customers[i][0] ;
            }
            else{
                ans +=( prev -  customers[i][0] ) +   (customers[i][1])  ;
                prev= prev + (customers[i][1]) ;
            }

        }
        return ans /customers.size() ;
    }
};
*/
/*
class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        double count = 0, curr = 0;
        for(auto& a : customers)
        {
            curr = max(curr, a[0] * 1.0) + a[1];
            count += curr - a[0];
        }
        return count / customers.size();
    }
};
*/
/*
class Solution {
public:
    double averageWaitingTime(vector<vector<int>>& customers) {
        double n = customers.size();
        double waitTime = 0;
        double timeTaken = customers[0][0]; //this should start with the first customer's arrival

        for(auto cust : customers){
            int arrival = cust[0];
            int prepTime = cust[1];

            if(arrival > timeTaken){
                //chef is free
                timeTaken = arrival + prepTime;
                waitTime += prepTime;
            }else{
                //chef is busy preparing orders
                timeTaken += prepTime;
                waitTime += timeTaken - arrival;
            }
        }

        return waitTime/n;
    }
};
*/