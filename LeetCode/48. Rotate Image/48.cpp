class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int nRows = matrix.size();
        int nColumns = matrix[0].size();

        //Step1. Transpose
        for(int i = 0; i<nRows; i++){
            for(int j = i; j<nColumns; j++){
                swap(matrix[i][j], matrix[j][i]);
            }
        }

        //Step2. Reverse Row Wise
        for(int i = 0; i<nRows; i++){
            reverse(matrix[i].begin(), matrix[i].end());
        }
        
    }
};

/*
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int row = matrix.size();
        for(int i=0;i<row; i++){
            for(int j=0; j<=i;j++){
                swap(matrix[i][j], matrix[j][i]);
            }
        }
        for(int i=0;i<row;i++){
            reverse(matrix[i].begin(), matrix[i].end());
        }
    }
};
*/
/*
class Solution {
public:
    
    void transpose(vector<vector<int>>& matrix){
        int n = matrix.size();
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix[i][j],matrix[j][i]);
            }
        }
    }
    
    void reflect(vector<vector<int>>& matrix){
        int n = matrix.size();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                swap(matrix[i][j],matrix[i][n-j-1]);
            }
        }
    }
    
    void rotate(vector<vector<int>>& matrix) {
        transpose(matrix);
        reflect(matrix);
    }
};
*/