class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = nums[0];

        for(int i=1;i<nums.length;i++){
            sum = Math.max(nums[i], nums[i] + sum);//start fresh or extend
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }
    // Time : O(n) <--> each element is checked only once
    // Space : O(1) <--> no extra space is taken only constant variables
}
