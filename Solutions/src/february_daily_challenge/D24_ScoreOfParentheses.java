package february_daily_challenge;

public class D24_ScoreOfParentheses {
    public static void main(String[] args) {
        ScoreOfParenthesesSolution sol = new ScoreOfParenthesesSolution();
        System.out.println(sol.scoreOfParentheses("()((()))"));
    }
}

class ScoreOfParenthesesSolution {
    public int scoreOfParentheses(String S) {
        int result = 0, n = 1;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                n *= 2;
            } else {
                n /= 2;
                if (chars[i - 1] == '(') result += n;
            }
        }
        return result;
    }
}