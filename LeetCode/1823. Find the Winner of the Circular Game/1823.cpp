class Solution
{
public:
    int findTheWinner(int n, int k)
    {
        int ans = 0;
        // intialize ans with 0 because we are 0 based indexing
        for (int i = 1; i <= n; i++)
        // iterate from 1 to n
        {
            //answill be updated by adding k and taking modulo with i
            //because we have to find the winner after kth person
            ans = (ans + k) % i;
        }
        //return ans+1 because we are 0 based indexing
        return ans + 1;
    }
};
//other people's solution
/*
class Solution {
public:
    int solve(int n, int k){
        if (n == 1) return 0;
        return (solve(n-1,k)+k)%n;
    }
    int findTheWinner(int n, int k) {
        return solve(n,k)+1;
    }
};
*/
/*
class Solution {
public:
int solve(int n,int k,vector<int>& arr,int s){
    if(arr.size()==1){
        return arr[0];//or return arr[0];
    }
    s=(s+k-1)%n;
    arr.erase(arr.begin()+s);
    int ans = solve(n-1,k,arr,s);
    return ans;


}
    int findTheWinner(int n, int k) {
       vector<int> arr;
       int s=0;
       for(int i=0;i<n;i++){
        arr.push_back(i+1);
       }
       int ans = solve(n,k,arr,s);
       return ans;
    }
};
*/
/*
class Solution {
public:

    int winner(vector<bool>& person, int n, int idx, int person_left, int k){

        if(person_left == 1){
            for(int i=0; i<n; i++){
               if( person[i]==0)
                  return i;
            }
        }
       int kill = (k-1)%person_left;

       while(kill--){
        idx = (idx+1) % n;
        // skip killed person
        while(person[idx] == 1){
            idx = (idx+1)%n;
        }
       }
       person[idx] =1;
      // next alive person
       while(person[idx] == 1){
        idx = (idx+1)%n;
       }
       return winner(person, n, idx, person_left-1, k);

    }
    int solve(int n, int k){
        if(n==1) return 0;

        return (solve(n-1, k) +k)%n;
    }
    int findTheWinner(int n, int k) {

        // vector<bool> person(n, 0);
        // int idx =0;
        // int person_left = n;

        // int ans= winner(person, n, idx, person_left, k);
        // return ans+1;

        return solve(n,k)+1;
    }
};
*/
/*
class Solution {
public:
    int findTheWinner(int n, int k) {
        // Initialize queue with n friends
        queue<int> circle;
        for (int i = 1; i <= n; ++i) {
            circle.push(i);
        }

        // Perform eliminations while more than 1 player remains
        while (circle.size() > 1) {
            // Process the first k-1 friends without eliminating them
            for (int i = 0; i < k - 1; ++i) {
                circle.push(circle.front());
                circle.pop();
            }
            // Eliminate the k-th friend
            circle.pop();
        }

        // Return the last remaining friend
        return circle.front();
    }
};
*/

/*
class Solution {
public:
    int findTheWinner(int n, int k) {
        if(n == 1) return 1;
  if(k == 1) return n;
  vector<int> arr(n);
  for(int i = 0; i < n; i++)
    arr[i] = i+1;

  int c = 1, i = 0, rem = n;
  while(1){
    i++;
    if(i==n)
      i = i%n;

    while(i < n && arr[i] == 0){
      i++;
      if(i==n)
        i = i%n;
    }

    c++;
    if(c == k){
      arr[i] = 0;
      while(i < n && arr[i] == 0){
        i++;
        if(i==n)
          i = i%n;
      }
      c = 1;
      rem--;
    }

    if(rem == 1)
      break;
  }

  int ans;
  for(i = 0; i < n; i++){
    if(arr[i] != 0){
      ans = arr[i];
      break;
    }
  }

  return ans;
    }
};
*/