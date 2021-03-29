package march_daily_challenge;

public class D28_ReconstructOriginalDigitsFromEnglish {
    public static void main(String[] args) {
        ReconstructOriginalDigitsFromEnglishSolution solution = new ReconstructOriginalDigitsFromEnglishSolution();
        System.out.println(solution.originalDigits("owoztneoer"));
    }
}

class ReconstructOriginalDigitsFromEnglishSolution {
    static final int[] DIGS = {0, 2, 4, 6, 8, 5, 7, 3, 9, 1}, CHARS = {25, 22, 20, 23, 6, 5, 18, 7, 8, 14};
    static final int[][] REMS = {{14}, {14}, {5, 14},{18, 8}, {8, 7}, {8}, {}, {}, {}, {}};
    public String originalDigits(String S) {
        int[] map = new int[26], answer = new int[10];
        char[] SCA = S.toCharArray();
        for (char c : SCA) map[c - 97]++;
        for (int i = 0; i < 10; i++) {
            int count = map[CHARS[i]];
            for (int rem : REMS[i]) map[rem] -= count;
            answer[DIGS[i]] = count;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            char c = (char)(i + 48);
            stringBuilder.append(String.valueOf(c).repeat(Math.max(0, answer[i])));
        }
        return stringBuilder.toString();
    }
}