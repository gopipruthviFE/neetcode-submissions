class Solution {
    public int maxProfit(int[] prices) {
        int stock = prices[0];
        int maxProfit = 0;

        for(int i=1;i<prices.length;i++){
            if(prices[i] < stock){// buy if you found stock at less price
                stock = prices[i];
            }else{// or else check what profit you can get from the stock price on that day
                maxProfit = Math.max(maxProfit, prices[i] - stock);
            }
        }

        return maxProfit;
    }
}
