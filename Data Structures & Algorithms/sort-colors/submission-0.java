class Solution {
    public void sortColors(int[] nums) {
        //high to end --> 2
        // mid to high --> unsorted
        // low + 1 to mid --> 1
        // 0 to low is 0

        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while(mid <= high){
            if(nums[mid] == 1){
                mid++;
            }else if(nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            }else{
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }

    // Time : O(n) <--> as we check each element only once
    // Space : O(1) <--> as we did not use any extra space
}