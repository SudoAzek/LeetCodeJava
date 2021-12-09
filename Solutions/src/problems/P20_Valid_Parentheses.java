package problems;

import java.util.HashMap;
import java.util.Stack;

public class P20_Valid_Parentheses {
    public static void main(String[] args) {
        Solution_Valid_Parentheses sol = new Solution_Valid_Parentheses();
        System.out.println(sol.isValid("["));
    }
}

class Solution_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (!st.empty() && st.get(st.size() - 1) == map.get(s.charAt(i))) {
                    st.pop();
                } else {
                    return false;
                }
            } else {
                st.add(s.charAt(i));
            }
        }
        return st.empty();
    }
}