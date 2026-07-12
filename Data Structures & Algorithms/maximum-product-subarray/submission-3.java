class Solution {
    public int maxProduct(int[] nums) {
        int minP = 1;
        int maxP = 1;

        int maxValue = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int prevMin = minP;
            int prevMax = maxP;

            maxP = Math.max(nums[i], Math.max(prevMax * nums[i], prevMin * nums[i]));
            minP = Math.min(nums[i], Math.min(prevMax * nums[i], prevMin * nums[i]));
            maxValue = Math.max(maxValue, maxP);
        }
        return maxValue;
    }

    // Time : O(n)
    // Space : O(1)
}
