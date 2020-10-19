package com.leetcode.easy;


public class Q121BestTimeToBuyAndSellSock {
    /**
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * <p>
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     * <p>
     * Note that you cannot sell a stock before you buy one.
     * <p>
     * Example 1:
     * <p>
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     *              Not 7-1 = 6, as selling price needs to be larger than buying price.
     * Example 2:
     * <p>
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 思路：想清楚实际交易的条件——即后面找到的高价要比前面找到的低价index要大
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int result = 0;
        for (int j = prices.length - 1; j > 0; j--) {
            int min = prices[j];
            for (int k = 0; k < j; k++) {
                min = Math.min(prices[k], min);
            }
            result = Math.max(result, prices[j] - min);
        }
        return result;
    }

    /**
     * 需要抽离一个问题：从买卖的角度讲，在当前时间之后的价格对我们来说没有意义，只需要考虑当前时间之前的价格
     */
    public int betterMaxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Q121BestTimeToBuyAndSellSock().maxProfit(new int[]{1, 4, 2}));
    }
}
