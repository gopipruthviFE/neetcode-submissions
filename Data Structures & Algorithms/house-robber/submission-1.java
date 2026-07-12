class Solution {
    public int robMoney(int i, int[] dp, int[] nums){
        if(i < 0){
            return 0;
        }
        if(i == 0){
            return dp[0] = nums[0];
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + robMoney(i - 2, dp, nums);
        int skip = robMoney(i - 1, dp, nums);

        return dp[i] = Math.max(take, skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        robMoney(n - 1, dp, nums);
        return dp[n - 1];
    }

    // Time : O(n)
    // Space : O(n)
}
