package june_daily_challenge;

public class D07_MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairsSolution solution = new MinCostClimbingStairsSolution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}

class MinCostClimbingStairsSolution {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }
}