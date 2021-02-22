package february_daily_challenge;

public class D21_BrokenCalculator {
    public static void main(String[] args) {
        BrokenCalculatorSolution solution = new BrokenCalculatorSolution();
        System.out.println(solution.brokenCalc(5, 8));
    }
}

class BrokenCalculatorSolution {
    public int brokenCalc(int X, int Y) {
        int res = 0;
        while (X < Y) {
            if (Y % 2 != 0) Y++;
            else Y /= 2;
            res++;
        }
        return res + X - Y;
    }
}


class BrokenCalculatorSolution_1 {
    public int brokenCalc(int X, int Y) {
        return func(X, Y, 0);
    }

    private int func(int x, int y, int result) {
        if (x >= y) return result + x - y;
        return func(x, (y % 2 != 0 ? y + 1 : y / 2), result + 1);
    }
}
