class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        int buy1 = Integer.MIN_VALUE;
        int sell1 = 0;
        for(int price : prices)
        {
            buy = Math.max(buy, -price);
            sell = Math.max(sell, buy + price);
            buy1 = Math.max(buy1, sell - price);
            sell1 = Math.max(sell1, buy1 + price);
        }
        return sell1;
    }
}