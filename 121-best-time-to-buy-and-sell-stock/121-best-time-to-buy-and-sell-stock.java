class Solution {
    public int maxProfit(int[] prices) {
        int bestBuy = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - bestBuy);
            bestBuy = Math.min(bestBuy, price);
        }
        
        return maxProfit;
    }
}