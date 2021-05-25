package may_daily_challenge;

public class D24_ToLowerCase {
    public static void main(String[] args) {
        ToLowerCaseSolution solution = new ToLowerCaseSolution();
        System.out.println(solution.toLowerCase("LOVELY"));
    }
}

class ToLowerCaseSolution {
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}

class ToLowerCaseSolution1 {
    public String toLowerCase(String s) {
        int i;
        int num;
        char[] a = s.toCharArray();
        for (i = 0; i < a.length; i++) {
            if (a[i] >= 'A' && a[i] <= 'Z') {
                num = a[i] + 32;
                a[i] = (char) num;
                System.out.print(a[i] + " " + num);
            }
        }
        return new String(a);
    }
}

class ToLowerCaseSolution2 {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if (s >= 65 && s <= 90)
                s = (char) (s + 32);
            sb.append(s + "");
        }
        return sb.toString();
        // return str.toLowerCase();
    }
}

class ToLowerCaseSolution3 {
    public String toLowerCase(String str) {
        String strArr[] = str.split("");
        String newStr = str.toLowerCase();

        return newStr;
    }
}