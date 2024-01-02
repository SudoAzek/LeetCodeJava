package problems;

public class P121_Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {

    }
}

class Solution_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = 0;

        for (int i= 0; i < prices.length; i++) {
            if (min < prices[i]) {
                int sum = prices[i] - min;
                max = Math.max(max, sum);
            } else {
                min = prices[i];
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int buyPointer = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[buyPointer]) {
                buyPointer = i;
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - prices[buyPointer]);
            }
        }
        return (maxProfit < 0 ? 0 : maxProfit);
    }
}