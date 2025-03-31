class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int minCostPrice = Integer.MAX_VALUE;
        for(int i = 0; i < n; ++i) {
            minCostPrice = Math.min(minCostPrice, prices[i]);
            profit = Math.max(profit, prices[i]-minCostPrice);
        }
        return profit;
    }

}
