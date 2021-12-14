package problems;

import java.util.Arrays;

public class P344_Reverse_String {
    public static void main(String[] args) {
        Solution_Reverse_String sol = new Solution_Reverse_String();
        sol.reverseString(new char[] {'h','e','l','l','o'});
    }
}

class Solution_Reverse_String {
    public void reverseString(char[] s) {
        int len = s.length;

        for (int i = 0, j = len - 1; i < len / 2 || j > len / 2; i++, j--) {
            char c = s[i];
            s[i] = s[j];
            s[j] = c;
        }
        System.out.println(Arrays.toString(s));
    }
}