class Solution {
    public int maxProfit(int[] prices) {
        int hold = prices[0];
        int profit = 0;// just holding prices[i] so no profit till now

        for(int i=1;i<prices.length;i++){
            if(prices[i] < hold){
                hold = prices[i];
            }
            profit = Math.max(profit, prices[i] - hold);// check profit on each day and update the max profit
        }

        return profit;
    }
    // Time : O(n) <--> as we check each price only pnce and there are n prices
    // Space : O(1) <--> no extra space is used
}
