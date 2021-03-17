package march_daily_challenge;

public class D16_BestTimeToBuyAndSellStockWithTransactionFee {
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFeeSolution sol = new BestTimeToBuyAndSellStockWithTransactionFeeSolution();
        System.out.println(sol.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}

class BestTimeToBuyAndSellStockWithTransactionFeeSolution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}