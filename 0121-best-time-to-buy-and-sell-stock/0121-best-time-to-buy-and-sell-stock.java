import java.util.*;
class Solution {
    public int maxProfit(int[] prices) {
        int min_value = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++){
            min_value = Math.min(min_value, prices[i]);
            profit = Math.max(profit, prices[i] - min_value);
        }

        return profit;
    }
}