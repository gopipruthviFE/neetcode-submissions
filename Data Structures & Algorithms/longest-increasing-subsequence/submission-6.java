class Solution {
    // public int lis(int i, int prevInd, int[] nums, int[][] dp){// length of lis using elements from i 
    //     if(i == nums.length){
    //         return 0;
    //     }
    //     if(dp[i][prevInd + 1] != -1){
    //         return dp[i][prevInd + 1];
    //     }

    //     int skip = lis(i + 1, prevInd, nums, dp);
    //     int take = 0;

    //     if(prevInd == -1 || nums[i] > nums[prevInd]){
    //         take = 1 + lis(i + 1, i, nums, dp);
    //     }

    //     return dp[i][prevInd + 1] = Math.max(skip, take);
    // }
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;

    //     int[][] dp = new int[n][n + 1];
    //     for(int[] row : dp){
    //         Arrays.fill(row, -1);
    //     }

    //     return lis(0, -1, nums, dp);
    // }

    // Time : O(n ^ 2) number of states
    // Space : O(n ^ 2) - dp array + O(n) - recurstion stack

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        dp[0] = 1;

        int best = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            best = Math.max(best, dp[i]);
        }

        return best;
    }
}
