package april_daily_challenge;

import java.util.Stack;

public class D16_RemoveAllAdjacentDuplicatesInStringII {
    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesInStringIISolution solution = new RemoveAllAdjacentDuplicatesInStringIISolution();
        System.out.println(solution.removeDuplicates("abcd", 2));
    }
}

class RemoveAllAdjacentDuplicatesInStringIISolution {
    public String removeDuplicates(String s, int k) {
        char[] sc = s.toCharArray();
        int i, j;
        Stack<Integer> st = new Stack<>();
        st.add(0);
        for (i = 1, j = 1; j < s.length(); i++, j++) {
            char chr = sc[i] = sc[j];
            if (i == 0 || chr != sc[i - 1]) st.add(i);
            else if (i - st.peek() + 1 == k) i = st.pop() - 1;
        }
        return new String(sc, 0, i);
    }
}