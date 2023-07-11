package problems;

public class P161_One_Edit_Distance {
    public static void main(String[] args) {

    }

    public static boolean isOneEditDistance(String s, String t) {
        int ns = s.length();
        int nt = t.length();

        if (ns > nt) {
            return isOneEditDistance(t, s);
        }

        if (nt - ns > 1) {
            return false;
        }

        for (int i = 0; i < ns; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (ns == nt) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return (ns + 1 == nt);
    }
}
