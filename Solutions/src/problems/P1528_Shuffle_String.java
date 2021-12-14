package problems;

public class P1528_Shuffle_String {
    public static void main(String[] args) {
        Solution_Shuffle_String sol = new Solution_Shuffle_String();
        System.out.println(sol.restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }
}

class Solution_Shuffle_String {
    public String restoreString(String s, int[] indices) {
        char[] chars = new char[s.length()];

        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }

        s = String.valueOf(chars);
        return s;
    }
}

class Solution_Shuffle_String2 {
    public String restoreString(String s, int[] indices) {
        char[] ch = new char[indices.length];
        int ind = 0;
        for (int i : indices) {
            ch[i] = s.charAt(ind++);
        }
        return new String(ch);
    }
}