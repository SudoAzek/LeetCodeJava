package march_daily_challenge;

public class D27_PalindromicSubstrings {
}

class PalindromicSubstringsSolution {
    public int countSubstrings(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            answer += countPalindromesAroundCenter(s, i, i);
            answer += countPalindromesAroundCenter(s, i, i + 1);
        }
        return answer;
    }

    private int countPalindromesAroundCenter(String s, int l, int h) {
        int answer = 0;

        while (l >= 0 && h < s.length()) {
            if (s.charAt(l) != s.charAt(h)) break;
            l--;
            h++;
            answer++;
        }
        return answer;
    }
}