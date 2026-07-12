class Solution {
    // public int computeCost(int i, int[] dp, int[] cost){
    //     if(i == 0 || i == 1){
    //         return dp[i] = 0;
    //     }
    //     if(dp[i] != -1){
    //         return dp[i];
    //     }

    //     return dp[i] = Math.min(cost[i - 1] + computeCost(i - 1, dp, cost), cost[i - 2] + computeCost(i - 2, dp, cost));
    // }
    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     int[] dp = new int[n + 1];
    //     Arrays.fill(dp, -1);

    //     computeCost(n, dp, cost);
    //     return dp[n];
    // }

    // Time : O(n)
    // Space : O(n)
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;

        for(int i=2;i<=n;i++){
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[n];
    }
}
