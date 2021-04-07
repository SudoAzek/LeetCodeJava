package april_daily_challenge;

public class D06_MinimumOperationsToMakeArrayEqual {
    public static void main(String[] args) {
        MinimumOperationsToMakeArrayEqualSolution solution = new MinimumOperationsToMakeArrayEqualSolution();
        System.out.println(solution.minOperations(3));
    }
}

class MinimumOperationsToMakeArrayEqualSolution {
    public int minOperations(int n) {
        return n * n >> 2;
    }
}