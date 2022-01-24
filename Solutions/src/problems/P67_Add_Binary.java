package problems;

public class P67_Add_Binary {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab", "a", "a"}));
    }


    public static String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
//        StringBuilder res = new StringBuilder();

        for (int i = 0; i < strs.length; i++) {
            if (minLen > strs[i].length()) {
                minLen = strs[i].length();
            }
        }


        for (int i = 0; i < minLen; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
//            res.append(c);
        }
        return strs[0];
//        return res.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        for (int uniCharPosi = 0; uniCharPosi < strs[0].length(); uniCharPosi++) {
            char c = strs[0].charAt(uniCharPosi);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length() == uniCharPosi || strs[i].charAt(uniCharPosi) != c) {
                    return strs[0].substring(0, uniCharPosi);
                }
            }
        }
        return strs[0];
    }
}
