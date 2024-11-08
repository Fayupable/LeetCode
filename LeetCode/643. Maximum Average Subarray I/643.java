class Solution {
    public double findMaxAverage(int[] arr, int k) {
        double sum=0.0d;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
       double presum=arr[0];
        double max=sum/k;
        int j=1;
        for(int i=k;i<arr.length;i++){
            sum=((sum+arr[i])-presum);
            double avg=sum/k;
            if(avg>max)
            max=avg;
            presum=arr[j++];   
        }
       return max;
  }
}