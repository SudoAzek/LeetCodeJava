package problems;

public class P443_String_Compression {
    public static void main(String[] args) {
        Solution_String_Compression sol = new Solution_String_Compression();
        System.out.println(sol.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
    }
}


class Solution_String_Compression {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        char currChar = chars[0];

        for (int i = 0; i < chars.length; i++) {
            if (currChar == chars[i]) {
                cnt++;
            } else {
                sb.append(currChar);
                sb.append(cnt);
                currChar = chars[i];
                cnt = 1;
            }
        }
        sb.append(currChar);
        sb.append(cnt);

        return sb.length();
    }
}

class Solution_String_Compression2 {
    public int compress(char[] chars) {
        int index = 0, count = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            count++;

            if (i == chars.length - 1 || chars[i] != chars[i + 1]) {
                chars[index++] = chars[i];
                if (count > 1) {
                    String s = String.valueOf(count);
                    for (int j = 0; j < s.length(); j++)
                        chars[index++] = s.charAt(j);
                }
                count = 0;
            }
        }
        System.out.println(chars);
        return index;
    }
}