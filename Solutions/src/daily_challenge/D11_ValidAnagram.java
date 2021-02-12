package daily_challenge;

import java.util.Arrays;

public class D11_ValidAnagram {
    public static void main(String[] args) {
        ValidAnagramSolution vas = new ValidAnagramSolution();
        ValidAnagramSolution_1 vas_1 = new ValidAnagramSolution_1();

        System.out.println(vas.isAnagram("azamat", "tamaza"));
        System.out.println(vas_1.isAnagram("azamat", "tamaza"));
    }
}

class ValidAnagramSolution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        for(int i = 0; i < sCharArray.length; i++) {
            if(sCharArray[i] != tCharArray[i]) return false;
        }
            return true;
    }
}

class ValidAnagramSolution_1 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);
        return Arrays.equals(sCharArray, tCharArray);
    }
}