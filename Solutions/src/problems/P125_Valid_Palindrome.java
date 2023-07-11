package problems;

import java.util.regex.Pattern;

public class P125_Valid_Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        String output = removeNonAlphanumeric(s);
        int start = 0;
        int end = output.length() - 1;


        while (start < end) {
            if (output.charAt(start) != output.charAt(end)) return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static String removeNonAlphanumeric(String input) {
        StringBuilder result = new StringBuilder();

        String lowercase = input.toLowerCase();

        for (int i = 0; i < lowercase.length(); i++) {
            char c = lowercase.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static boolean isPalindrome2(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
        }
        return true;
    }

//    public static String removeNonAlphanumerics(String s) {
//        Pattern patter = Pattern.compile("[^a-zA-Z0-9]");
//        String result = patter.matcher(s).replaceAll("");
//        return result;
//    }
}
