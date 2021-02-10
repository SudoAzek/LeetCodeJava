package daily_challenge;

import java.util.Arrays;

import static java.lang.Integer.min;

public class D07_ShortestDistanceToCharacter {
    public static void main(String[] args) {
        ShortestDistanceToCharacterSolution shortestDistanceToCharacterSolution = new ShortestDistanceToCharacterSolution();
        System.out.println(Arrays.toString(shortestDistanceToCharacterSolution.shortestToChar("loveleetcode", 'e')));
    }
}

/*
class Solution:
    def shortestToChar(self, s: str, c: str) -> List[int]:
        n = len(s)
        res = [0 if s[0] == c else float('inf')]

        for i in range(1, n):
            res.append(0 if s[i] == c else res[i - 1] + 1)

        for i in reversed(range(n - 1)):
            res[i] = min(res[i], res[i + 1] + 1)

        return res
 */


class ShortestDistanceToCharacterSolution {
    public int[] shortestToChar(String s, char c) {
        int l = s.length();
        int[] ans = new int[l];

        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
            } else {
                ans[i] =+ i;
            }
        }
        for (int i = l - 1; i > 0; i--) {
            ans[i] = min(ans[i], ans[i] =+ 1);
        }
        return ans;
    }
}