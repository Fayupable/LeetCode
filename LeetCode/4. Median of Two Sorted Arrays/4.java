class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] sol = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                sol[k++] = nums1[i++];
            } else {
                sol[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            sol[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            sol[k++] = nums2[j++];
        }
        if (sol.length % 2 == 0) {
            return (sol[sol.length / 2 - 1] + sol[sol.length / 2]) / 2.0;
        } else {
            return sol[sol.length / 2];
        }
    }
}
