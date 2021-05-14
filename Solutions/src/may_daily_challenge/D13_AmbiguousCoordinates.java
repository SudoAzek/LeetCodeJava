package may_daily_challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class D13_AmbiguousCoordinates {
    public static void main(String[] args) {
        AmbiguousCoordinatesSolution solution = new AmbiguousCoordinatesSolution();
        System.out.println(solution.ambiguousCoordinates("(123)"));
    }
}

class AmbiguousCoordinatesSolution {
    private List<String> xPos, answer;

    public List<String> ambiguousCoordinates(String s) {
        answer = new ArrayList<>();
        for (int i = 2; i < s.length() - 1; i++) {
            String[] strings = {s.substring(1, i), s.substring(i, s.length() - 1)};
            xPos = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                if (xPos.size() > 0 || j == 0) parse(strings[j], j);
            }
        }
        return answer;
    }

    private void parse(String string, int xy) {
        if (string.length() == 1 || string.charAt(0) != '0') process(string, xy);
        if (string.length() > 1 && string.charAt(string.length() - 1) != '0')
            process(string.substring(0, 1) + "." + string.substring(1), xy);
        if (string.length() > 2 && string.charAt(0) != '0' && string.charAt(string.length() - 1) != '0')
            for (int i = 2; i < string.length(); i++) {
                process(string.substring(0, i) + "." + string.substring(i), xy);
            }
    }

    private void process(String string, int xy) {
        if (xy > 0)
            for (String x : xPos) answer.add("(" + x + ", " + string + ")");
        else xPos.add(string);
    }
}

class AmbiguousCoordinatesSolution1 {
    private String s;
    public List<String> ambiguousCoordinates(String s) {
        this.s = s;
        int n = s.length();
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n - 2; i++) {
            var left = parseNums(1, i);
            if (left.isEmpty()) {
                continue;
            }
            var right = parseNums(i + 1, n - 2);
            if (right.isEmpty()) {
                continue;
            }
            for (var l : left) {
                for (var r : right) {
                    res.add("(" + l + ", " + r + ")");
                }
            }
        }
        return res;
    }

    private List<String> parseNums(int i, int j) {
        List<String> res = new ArrayList<>();
        if (s.charAt(i) != '0' || i == j) {
            res.add(s.substring(i, j + 1));
        }
        if (s.charAt(j) == '0' || i == j) {
            return res;
        }
        int end = s.charAt(i) == '0' ? i : j - 1;
        for (int k = i; k <= end; k++) {
            res.add(s.substring(i, k + 1) + "." + s.substring(k + 1, j + 1));
        }
        return res;
    }
}

class AmbiguousCoordinatesSolution2 {
    public List<String> ambiguousCoordinates(String S) {
        S = S.substring(1, S.length() - 1);
        List<String> result = new LinkedList<>();
        for (int i = 1; i < S.length(); i++) {
            List<String> left = allowed(S.substring(0, i));
            List<String> right = allowed(S.substring(i));
            for (String ls : left) {
                for (String rs : right) {
                    result.add("(" + ls + ", " + rs + ")");
                }
            }
        }
        return result;
    }
    private List<String> allowed(String s) {
        int l = s.length();
        char[] cs = s.toCharArray();
        List<String> result = new LinkedList<>();
        if (cs[0] == '0' && cs[l - 1] == '0') { // "0xxxx0" Invalid unless a single "0"
            if (l == 1) {
                result.add("0");
            }
            return result;
        }
        if (cs[0] == '0') { // "0xxxxx" The only valid result is "0.xxxxx"
            result.add("0." + s.substring(1));
            return result;
        }
        if (cs[l - 1] == '0') { // "xxxxx0" The only valid result is itself
            result.add(s);
            return result;
        }
        result.add(s); // Add itself
        for (int i = 1; i < l; i++) { // "xxxx" -> "x.xxx", "xx.xx", "xxx.x"
            result.add(s.substring(0, i) + '.' + s.substring(i));
        }
        return result;
    }

}