package problems;

public class P1221_Split_a_String_in_Balanced_Strings {
    public static void main(String[] args) {
        Solution_Split_a_String_in_Balanced_Strings sol = new Solution_Split_a_String_in_Balanced_Strings();
        System.out.println(sol.balancedStringSplit("RLRRLLRLRL"));
    }
}

class Solution_Split_a_String_in_Balanced_Strings {
    public int balancedStringSplit(String s) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == 'L' ? 1 : -1;
            if (count == 0) res++;
        }
        return res;
    }
}

class Solution_Split_a_String_in_Balanced_Strings2 {
    public int balancedStringSplit(String s) {
        int r = 0;
        int l = 0;
        int partion = 0;

        if (s.length() < 1) {
            partion = 0;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'R') {
                    r++;
                } else if (s.charAt(i) == 'L') {
                    l++;
                }

                if (r == l) {
                    partion++;
                }
            }
        }
        return partion;
    }
}