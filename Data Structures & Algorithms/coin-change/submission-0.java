class Solution {
    public int minCoins(int amount, int[] coins, int[] dp){
        if(amount == 0){
            return dp[amount] = 0;
        }
        if(amount < 0){
            return Integer.MAX_VALUE;
        }
        if(dp[amount] != -1){
            return dp[amount];
        }
        int best = Integer.MAX_VALUE;

        for(int coin : coins){
            int sub = minCoins(amount - coin, coins, dp);
            if(sub != Integer.MAX_VALUE){
                best = Math.min(best, 1 + sub);
            }
        }
        return dp[amount] = best;
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        minCoins(amount, coins, dp);
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
