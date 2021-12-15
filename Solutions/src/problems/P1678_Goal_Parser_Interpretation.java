package problems;

public class P1678_Goal_Parser_Interpretation {
    public static void main(String[] args) {
        Solution_Goal_Parser_Interpretation_with_Regex sol = new Solution_Goal_Parser_Interpretation_with_Regex();
        System.out.println(sol.interpret("G()(al)"));
        Solution_Goal_Parser_Interpretation_without_Regex sol2 = new Solution_Goal_Parser_Interpretation_without_Regex();
        System.out.println(sol2.interpret("G()(al)"));
    }
}

class Solution_Goal_Parser_Interpretation_with_Regex {
    public String interpret(String command) {
        return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
    }
}

class Solution_Goal_Parser_Interpretation_without_Regex {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (i + 1 < command.length() && command.charAt(i + 1) == ')') {
                sb.append("o");
                i++;
            } else {
                sb.append("al");
                i += 3;
            }
        }
        return sb.toString();
    }
}