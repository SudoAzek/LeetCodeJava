package february_daily_challenge;

public class D18_ArithmeticSlices {
    public static void main(String[] args) {
        ArithmeticSlicesSolution solution = new ArithmeticSlicesSolution();
        ArithmeticSlicesSolution_2 solution_2 = new ArithmeticSlicesSolution_2();
        System.out.println(solution.numberOfArithmeticSlices(new int[]{3, -1, -5, -9}));
        System.out.println(solution_2.numberOfArithmeticSlices(new int[]{3, -1, -5, -9}));
    }
}

class ArithmeticSlicesSolution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        int cnt = 0;
        int res = 0;

        for (int i = 2; i < A.length; i++) {
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) cnt++;
            else cnt = 0;
            res += cnt;
        }
        return res;
    }
}

class ArithmeticSlicesSolution_2 {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;
        for(int i = 0; i < A.length - 2; i++) {
            int d = A[i + 1] - A[i];
            for(int j = i + 2; j < A.length; j++) {
                if(A[j] - A[j - 1] == d) res++;
                else break;
            }
        }
        return res;
    }
}
