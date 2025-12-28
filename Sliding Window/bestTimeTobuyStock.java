class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int l = 0, r = l + 1, minBuy = prices[l];
        int maxProfit = 0;

        while (r < n) {
            if (prices[r] > minBuy) {
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                minBuy = prices[r];
                l = r;
            }
            r++;
        }

        return maxProfit;
    }
}