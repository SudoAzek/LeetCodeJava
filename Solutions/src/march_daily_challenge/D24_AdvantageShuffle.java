package march_daily_challenge;

import java.util.Arrays;

public class D24_AdvantageShuffle {
    public static void main(String[] args) {
        AdvantageShuffleSolution solution = new AdvantageShuffleSolution();
        System.out.println(Arrays.toString(solution.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
    }
}

class AdvantageShuffleSolution {
    public int[] advantageCount(int[] A, int[] B) {
        Integer[] order = new Integer[B.length];
        int[] answer = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> Integer.compare(B[b], B[a]));
        Arrays.sort(A);
        int i = 0, j = B.length - 1;
        for (int ix : order) {
            answer[ix] = A[j] > B[ix] ? A[j--] : A[i++];
        }
        return answer;
    }
}