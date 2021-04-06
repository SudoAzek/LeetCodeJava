package april_daily_challenge;

public class D05_GlobalAndLocalInversions {
    public static void main(String[] args) {
        GlobalAndLocalInversionsSolution solution = new GlobalAndLocalInversionsSolution();
        System.out.println(solution.isIdealPermutation(new int[] {1, 0, 2}));
    }
}

class GlobalAndLocalInversionsSolution {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (i - A[i] > 1 || i - A[i] < -1) return false;
        }
        return true;
    }
}