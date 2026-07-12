class Solution {
    public int climb(int i, int[] dp){
        if(i == 0 || i == 1){
            return dp[i] = 1;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        return dp[i] = climb(i - 1, dp) + climb(i - 2, dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        climb(n, dp);
        return dp[n];
    }
    
    // Time : O(n)
    // Space : O(n)
}
