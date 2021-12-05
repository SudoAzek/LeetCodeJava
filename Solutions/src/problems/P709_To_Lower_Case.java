package problems;

public class P709_To_Lower_Case {
    public static void main(String[] args) {

    }
}

class Solution_To_Lower_Case {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}


class Solution_To_Lower_Case2 {
    public String toLowerCase(String string) {
        char[] charArray = string.toCharArray();
        int diff = 'A' - 'a';
        for (int index = 0; index < charArray.length; index++) {
            if (charArray[index] >= 'A' && charArray[index] <= 'Z') {
                charArray[index] -= diff;
            }
        }
        return new String(charArray);
    }
}