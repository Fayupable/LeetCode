class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int maxArea=0;
        int cols=matrix[0].length;
        int[] heights=new int[cols+1];
        for(char[]row:matrix){
            for(int i=0;i<cols;i++){
                //update the heights of this histogram
                if(row[i]=='1'){
                    heights[i]++;
                }else{
                    heights[i]=0;
                }
            }
            //compute maximal rectangle in the histogram
            maxArea=Math.max(maxArea,maxHistogramArea(heights));
        }
        return maxArea;
        
    }
    private int maxHistogramArea(int[] heights) {
        int maxArea = 0;
        int index = 0;
        int[] stack = new int[heights.length];
        int top = -1;

        while (index < heights.length) {

            //push to stack if the current bar is higher than the bar at stack top
            if (top == -1 || heights[index] >= heights[stack[top]]) {
                stack[++top] = index++;
            } else {
                int height = heights[stack[top--]];

                //calculate width
                int width = (top == -1) ? index : index - stack[top] - 1;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }

}