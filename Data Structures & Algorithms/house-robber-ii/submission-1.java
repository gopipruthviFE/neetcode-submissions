class Solution {
    public int robMoney(int i, int start, int[] dp, int[] nums){
        if(i < start){
            return 0;
        }
        if(i == start){
            return dp[i] = nums[start];
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + robMoney(i - 2, start, dp, nums);
        int skip = robMoney(i - 1, start, dp, nums);

        return dp[i] = Math.max(take, skip);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(robMoney(n - 2, 0, dp1, nums), robMoney(n - 1, 1, dp2, nums));
    }
}
