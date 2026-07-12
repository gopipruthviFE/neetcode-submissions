class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        int left = 0;
        int zeroCount = 0;

        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                zeroCount++;
            }

            while(zeroCount > k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }
    // Time : O(n) <--> as we check each element only one time
    // Space : O(1) <--> no extra space is taken only constant variables
}