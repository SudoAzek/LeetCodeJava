package april_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class D08_LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumberSolution solution = new LetterCombinationsOfPhoneNumberSolution();
        System.out.println(solution.letterCombinations("23"));
    }
}

class LetterCombinationsOfPhoneNumberSolution {
    final char[][] LETTERS = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> answer = new ArrayList<>();
        if (len == 0) return answer;
        bfs(0, len, new StringBuilder(), answer, digits);
        return answer;
    }

    public void bfs(int pos, int len, StringBuilder sb, List<String> answer, String digits) {
        if (pos == len) answer.add(sb.toString());
        else {
            char[] letters = LETTERS[Character.getNumericValue(digits.charAt(pos))];
            for (int i = 0; i < letters.length; i++) {
                bfs(pos + 1, len, new StringBuilder(sb).append(letters[i]), answer, digits);
            }
        }
    }
}