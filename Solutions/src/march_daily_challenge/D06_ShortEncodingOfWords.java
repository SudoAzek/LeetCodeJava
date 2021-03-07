package march_daily_challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class D06_ShortEncodingOfWords {
    public static void main(String[] args) {
        ShortEncodingOfWordsSolution sol = new ShortEncodingOfWordsSolution();
        System.out.println(sol.minimumLengthEncoding(new String[] {"time", "me", "bell"} ));
    }
}

class ShortEncodingOfWordsSolution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet(Arrays.asList(words));
        for (String string : words) {
            for (int i = 1; i < string.length(); ++i) {
                set.remove(string.substring(i));
            }
        }
        int ans = 0;
        for (String s : set) {
            ans += s.length() + 1;
        }
        return ans;
    }
}