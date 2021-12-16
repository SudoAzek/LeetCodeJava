package problems;

public class P557_Reverse_Words_in_a_String_III {
    public static void main(String[] args) {
        Solution_Reverse_Words_in_a_String_III sol = new Solution_Reverse_Words_in_a_String_III();
        System.out.println(sol.reverseWords("Let's take LeetCode contest"));
    }
}

class Solution_Reverse_Words_in_a_String_III {
    public String reverseWords(String s) {
        char tempChar;

        StringBuilder sb = new StringBuilder();

        String[] words = s.split("\\s");

        for (String word : words) {
            for (int i = word.length() - 1; i >= 0; i--) {
                sb.append(word.charAt(i));
            }
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}

class Solution_Reverse_Words_in_a_String_III2 {
    public String reverseWords(String s) {
        char[] r = s.toCharArray();
        recurseWordsSwap(r, 0);
        return String.valueOf(r);
    }

    void recurseWordsSwap(char[] s, int x) {
        if (x > s.length - 1) {
            return;
        }

        int y = x;

        while (y < s.length && s[y] != ' ') {
            y++;
        }

        reverseWord(s, x, y - 1);
        recurseWordsSwap(s, y + 1);
    }

    private void reverseWord(char[] s, int x, int y) {
        while (y > x) {
            char swap = s[x];
            s[x] = s[y];
            s[y] = swap;

            x++;
            y--;
        }
    }
}

class Solution_Reverse_Words_in_a_String_III3 {
    public String reverseWords(String s) {
        int i = 0;
        char[] chars = s.toCharArray();
        int j = 0;
        while (j <= chars.length) {
            if (j == chars.length || chars[j] == ' ') {
                reverseWord(i, j - 1, chars);
                i = j + 1;
            }
            j++;
        }
        return new String(chars);
    }

    public void reverseWord(int start, int end, char[] s) {
        while (start < end) {
            char temp = s[end];
            s[end] = s[start];
            s[start] = temp;
            start++;
            end--;
        }
    }
}