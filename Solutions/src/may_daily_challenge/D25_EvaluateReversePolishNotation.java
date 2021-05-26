package may_daily_challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class D25_EvaluateReversePolishNotation {
    public static void main(String[] args) {
        EvaluateReversePolishNotationSolution solution = new EvaluateReversePolishNotationSolution();
        System.out.println(solution.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "/", "", "17", "+", "5", "+"}));
    }
}

class EvaluateReversePolishNotationSolution {
    private Set<String> operations = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!operations.contains(token)) stack.push(Integer.parseInt(token));
            else {
                int b = stack.pop(), a = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    default:
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }
}

class EvaluateReversePolishNotationSolution1 {
    int pos;

    public int evalRPN(String[] tokens) {
        //missing some tests because it is given that RPN is always valid
        //therefore not testing before poping that whether there is somthing or not just skipping due to given assumptions
        //trying recursive variant
        pos = tokens.length;
        return dfs(tokens);
    }

    public int dfs(String[] tokens) {

        pos--;
        //you have to save current value of token because next iterations will modify pos untill you reach return part
        String token = tokens[pos];
        if (!"+-/*".contains(tokens[pos]))
            return Integer.parseInt(tokens[pos]);

        int a, b;
        a = dfs(tokens); //right operand for operator
        b = dfs(tokens); //left operand for operator

        if (token.equals("+")) //== test for addresses which we dont want thats why using equals
            return a + b;
        if (token.equals("-")) //== test for addresses which we dont want thats why using equals
            return b - a;
        if (token.equals("*")) //== test for addresses which we dont want thats why using equals
            return a * b;
        return b / a;
    }
}