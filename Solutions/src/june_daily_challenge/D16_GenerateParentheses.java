package june_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class D16_GenerateParentheses {
    public static void main(String[] args) {
        GenerateParenthesesSolution solution = new GenerateParenthesesSolution();
        System.out.println(solution.generateParenthesis(3));
    }
}

class GenerateParenthesesSolution {
    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        m = 2 * n;
        dfs(0, 0, 0);
        return answer;
    }

    private List<String> answer;
    private int m;

    private void dfs(int pos, int open, int seq) {
        if (pos == m) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < m; i++) {
                result.append((seq & 1 << i) > 0 ? "(" : ")");
            }
            answer.add(result.toString());
            return;
        }
        if (open > 0) dfs(pos + 1, open - 1, seq);
        if (m - pos > open) dfs(pos + 1, open + 1, seq | 1 << pos);
    }
}

class GenerateParenthesesSolution2 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, int open, int close, int n) {
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            helper(res, sb, open + 1, close, n);
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            helper(res, sb, open, close + 1, n);
            sb.setLength(sb.length() - 1);
        }
    }
}
