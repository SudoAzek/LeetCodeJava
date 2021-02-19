package february_daily_challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class D16_LetterCasePermutation {
    public static void main(String[] args) {
        String S = "C";
        LetterCasePermutationSolution solution = new LetterCasePermutationSolution();
        System.out.println(solution.letterCasePermutation(S));
    }
}


class LetterCasePermutationSolution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new LinkedList<>();
        permHelper( S.toCharArray(), 0, list);
        return list;
    }

    private void permHelper( char[] strArr, int pos, List<String> list ){
        if( pos == strArr.length ){
            list.add(new String(strArr));
            return;
        }

        if( strArr[pos] >='0' && strArr[pos] <= '9' ){
            permHelper( strArr, pos + 1, list);
            return;
        }

        strArr[pos] = Character.toUpperCase(strArr[pos]);
        permHelper( strArr, pos + 1, list);

        strArr[pos] = Character.toLowerCase(strArr[pos]);
        permHelper( strArr, pos + 1, list);

    }
}

class LetterCasePermutationSolution_1 {
    public List<String> letterCasePermutation(java.lang.String S) {
        List<String> permutated = new ArrayList<>();
        permutate(permutated, S.toCharArray(), 0);
        permutated.add(S);
        return permutated;
    }

    public void permutate(List<String> permutated, char[] ch, int i) {
        if(ch.length == i) return;
        permutate(permutated, ch, i + 1);
        if (Character.isDigit(ch[i])) return;
        ch[i] = Character.isUpperCase(ch[i]) ? Character.toLowerCase(ch[i]) : Character.toUpperCase(ch[i]);
        permutated.add(new String(ch));
        permutate(permutated, ch, i + 1);
    }
}


class LetterCasePermutationSolution_2 {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        if (isAlpha(S)) {
            list.add(S);
            int charCnt = 0;
            for (int i = 0; i < S.length(); i++) {
                if(Character.isLetter(S.charAt(i))) {
                    String s;
                    if(Character.isLowerCase(S.charAt(i))) {
                        s = S.substring(0, i) + S.substring(i, i + 1).toUpperCase() + S.substring(i + 1);
                    } else{
                        s = S.substring(0, i) + S.substring(i, i + 1).toLowerCase() + S.substring(i + 1);
                    }
                    list.add(s);
                    charCnt++;
                }
            }
            if(charCnt > 1) {
                S = S.toUpperCase();
                list.add(S);
            }
        } else {
            list.add(S);
        }

        return list;
    }
    public static boolean isAlpha(String s) {
        return s != null && s.matches(".*[a-zA-Z]+.*");
    }
}
