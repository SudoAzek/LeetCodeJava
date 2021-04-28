package april_daily_challenge;

public class D27_PowerOfThree {
    public static void main(String[] args) {

    }
}

class PowerOfThreeSolution {
    public boolean isPowerOfThree(int n) {
        double a = Math.log(n) / Math.log(3);
        return Math.abs(a - Math.round(a)) < 1e-10;
    }
}