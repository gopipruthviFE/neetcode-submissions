class Solution {
    public int findMin(int[] nums) {
       // one side is always sorted
       // mid compared with low doesnot give any info just says sorted
       // mid compared with high says weather min lies on 2nd half

       int n = nums.length;
       int low = 0;
       int high = n - 1;

       while(low < high){
        int mid = low + (high - low) / 2;

        if(nums[mid] <= nums[high]){// mid can be the minimum
            high = mid;
        }else{// here we definately know than mid cannot be minimum
            low = mid + 1;
        }
       }
       return nums[low];
    }

    // Time : O(Logn)
    // Space : O(1)
}
