class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int m = nums1.length;
      int n = nums2.length;

      if(m > n){
        return findMedianSortedArrays(nums2, nums1);
      }

      int low = 0;
      int high = m;

      int half = (1 + m + n) / 2;

      while(low <= high){
        int mid1 = low + (high - low) / 2;

        int mid2 = half - mid1;

        int maxLeft1 = mid1 != 0 ? nums1[mid1 - 1] : Integer.MIN_VALUE;
        int maxLeft2 = mid2 != 0 ? nums2[mid2 - 1] : Integer.MIN_VALUE;
        int minRight1 = mid1 != m ? nums1[mid1] : Integer.MAX_VALUE;
        int minRight2 = mid2 != n ? nums2[mid2] : Integer.MAX_VALUE;

        if(maxLeft1 <= minRight2 && maxLeft2 <= minRight1){
            if((m + n) % 2 == 0){
                return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
            }else{
                return Math.max(maxLeft1, maxLeft2);
            }
        }else if(maxLeft1 > minRight2){
            high = mid1 - 1;
        }else{
            low = mid1 + 1;
        }
      }

      return -1.0;
    }
    // Time : O(Log(min(m, n)))
}
