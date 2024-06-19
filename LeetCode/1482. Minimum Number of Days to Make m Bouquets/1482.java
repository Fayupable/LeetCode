class Solution {
    // Declare instance variables for the bloom days array and the number of bouquets and flowers per bouquet
    int arr[];
    int m, k;

    public int minDays(int[] arr, int m, int k) {
        // If the total number of flowers needed is less than 0 or greater than the number of flowers in the garden, return -1
        if(m * k < 0 || m * k > arr.length)
            return -1;

        // Initialize the instance variables
        this.m = m;
        this.k = k;
        this.arr = arr;

        // Find the maximum bloom day in the array
        int max = arr[0];
        for(int i = 1; i < arr.length; i++)
            max = Math.max(max, arr[i]);

        // Initialize the start, end, and middle of the binary search range
        int st = 1, en = max, md;

        // While the start is less than or equal to the end
        while(st <= en) {
            // Calculate the middle of the range
            md = (st + en) / 2;
            // If it's possible to make the required number of bouquets by the middle day
            if(count(md)) {
                // Update the end of the range to the day before the middle day
                en = md - 1;
            }
            else
            // Update the start of the range to the day after the middle day
            st = md + 1;
        }

        // Return the start of the range, which is the minimum number of days required to make the required number of bouquets
        return st;
    }

    // Define a method that takes a day as input and returns a boolean indicating whether it's possible to make the required number of bouquets by that day
    boolean count(int val) {
        // Initialize variables to keep track of the number of flowers in the current bouquet and the number of bouquets
        int temp = 0, temp2 = 0;

        // Iterate over the bloom days array
        for(int i = 0; i < arr.length; i++) {
            // If the bloom day of the current flower is less than or equal to the given day
            if(arr[i] <= val) {
                // Increment the number of flowers in the current bouquet
                temp++;
                // If the current bouquet is complete
                if(temp == k) {
                    // Reset the number of flowers in the current bouquet and increment the number of bouquets
                    temp = 0;
                    temp2++;
                    // If the required number of bouquets have been made, return true
                    if(temp2 == m)
                        return true;
                }
            }
            else {
                // If it's not possible to make the required number of bouquets with the remaining flowers, return false
                if((arr.length - i) / k < m - temp2)
                    return false;
                // Reset the number of flowers in the current bouquet
                temp = 0;
            }
        }
        // If we exit the loop without being able to make the required number of bouquets, return false
        return false;
    }
}

/*
 class Solution {

    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = 1, high = (int) 1e9;
        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isPossibleBouquets(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        };

        return low;
    }

    private boolean isPossibleBouquets(int[] bloomDay, int m, int k, int day) {
        int total = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            int count = 0;
            while (i < bloomDay.length && count < k && bloomDay[i] <= day) {
                count++;
                i++;
            }

            if (count == k) {
                total++;
                i--;
            }

            if (total >= m) {
                return true;
            }
        }

        return false;
    }

}
 */
/*
 class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k<0||m*k>bloomDay.length){
            return -1;
        }
        int left=-1;
        int right=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            if(left>bloomDay[i]){
                left=bloomDay[i];
            }else if(right<bloomDay[i]){
                right=bloomDay[i];
            }    
        }
        while(left<=right){
            int mid=(left+right)/2;
            boolean possible=possiblef(bloomDay,m,k,mid);
            if(!possible){
                left=mid+1;
            }
            else{
                min=Math.min(min,mid);
                right=mid-1;
            }
        }
        return min;
    }
    public boolean possiblef(int[] bloomDay,int m,int k,int day){
      int total = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            int count = 0;
            while (i < bloomDay.length && count < k && bloomDay[i] <= day) {
                count++;
                i++;
            }

            if (count == k) {
                total++;
                i--;
            }

            if (total >= m) {
                return true;
            }
        }

        return false;
    }
}
 */
/*
 class Solution {
    public int minDays(int[] bloom, int m, int k) {
        int low=1;
        int high=-1;
        for(int i:bloom){
            high=Math.max(high,i);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            int boques=0;
            int count=0;
            for(int i=0;i<bloom.length;i++){
                while(i!=bloom.length && bloom[i]<=mid){
                    count++;
                    i++;
                }
                boques+=(count/k);
                count=0;
            }
            if(boques>=m){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
 */

 /*
  class Solution {

    // Return the number of maximum bouquets that can be made on day mid.
    private int getNumOfBouquets(int[] bloomDay, int mid, int k) {
        int numOfBouquets = 0;
        int count = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            // If the flower is bloomed, add to the set. Else reset the count.
            if (bloomDay[i] <= mid) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                numOfBouquets++;
                count = 0;
            }
        }

        return numOfBouquets;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int start = 0;
        int end = 0;
        for (int day : bloomDay) {
            end = Math.max(end, day);
        }

        int minDays = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minDays;
    }
}
  */