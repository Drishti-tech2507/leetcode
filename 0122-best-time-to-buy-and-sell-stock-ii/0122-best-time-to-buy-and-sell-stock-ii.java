class Solution {
    public int maxProfit(int[] prices) {
        int i, p = 0;
        for (i = 1; i < prices.length ; i++)
        {
           if(prices[i] > prices[i - 1])
           {
             p += prices[i] - prices[i - 1];
           }
        }
        return p;
    }
}