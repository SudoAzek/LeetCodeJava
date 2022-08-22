package problems;

import java.util.HashMap;

public class P205_Isomorphic_Strings {
    public static void main(String[] args) {
        Isomorphic_Strings_Solution solution = new Isomorphic_Strings_Solution();
        System.out.println(solution.isIsomorphic("badc", "baba"));
    }

}

class Isomorphic_Strings_Solution {
    public String transformString(String s) {
        HashMap<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (!indexMapping.containsKey(c1)) {
                indexMapping.put(c1, i);
            }

            builder.append(Integer.toString(indexMapping.get(c1)));
            builder.append(" ");
        }
        return builder.toString();
    }

    public boolean isIsomorphic(String s, String t) {
        return transformString(s).equals(transformString(t));
    }
}