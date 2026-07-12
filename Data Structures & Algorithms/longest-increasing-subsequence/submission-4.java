class Solution {
    public int lis(int i, int prevInd, int[] nums, int[][] dp){// length of lis using elements from i 
        if(i == nums.length){
            return 0;
        }
        if(dp[i][prevInd + 1] != -1){
            return dp[i][prevInd + 1];
        }

        int skip = lis(i + 1, prevInd, nums, dp);
        int take = 0;

        if(prevInd == -1 || nums[i] > nums[prevInd]){
            take = 1 + lis(i + 1, i, nums, dp);
        }

        return dp[i][prevInd + 1] = Math.max(skip, take);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][n + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return lis(0, -1, nums, dp);
    }
}
