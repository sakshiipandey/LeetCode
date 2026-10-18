class Solution {
public int maxProfit(int[] prices) {

    int sellStock = 0;
    int profit = 0;
    int buyStock = prices[0];

    for(int i = 1; i<prices.length; i++) {

        if(prices[i] < buyStock) {
            buyStock = prices[i];
        } else {
            sellStock = prices[i] - buyStock;
        }

        profit = Math.max(profit, sellStock);
    }

    return profit;
}
}
