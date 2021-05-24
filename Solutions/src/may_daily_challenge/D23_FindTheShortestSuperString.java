package may_daily_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D23_FindTheShortestSuperString {
}


class FindTheShortestSuperStringSolution {
    public String shortestSuperString(String[] words) {
        int len = words.length;

        int[][] overlaps = new int[len][len];
        for (int i = 0; i < len; i++) { //TODO ++i
            for (int j = 0; j < len; j++) { //TODO ++j
                int m = Math.min(words[i].length(), words[j].length());
                for (int k = m; k >= 0; k--) { //TODO --k
                    if (words[i].endsWith(words[j].substring(0, k))) {
                        overlaps[i][j] = k;
                        break;
                    }
                }
            }
        }

        int[][] dp = new int[1 << len][len];
        int[][] parent = new int[1 << len][len];
        for (int mask = 0; mask < (1 << len); ++mask) {
            Arrays.fill(parent[mask], -1);

            for (int bit = 0; bit < len; bit++) //TODO ++bit
                if (((mask >> bit) & 1) > 0) {
                    int pMask = mask ^ (1 << bit);
                    if (pMask == 0) continue;
                    for (int i = 0; i < len; i++) { //TODO ++i
                        if (((pMask >> i) & 1) > 0) {
                            int val = dp[pMask][i] + overlaps[i][bit];
                            if (val > dp[mask][bit]) {
                                dp[mask][bit] = val;
                                parent[mask][bit] = i;
                            }
                        }
                    }
                }
        }

        int[] perm = new int[len];
        boolean[] seen = new boolean[len];
        int t = 0;
        int mask = (1 << len) - 1;

        int p = 0;
        for (int i = 0; i < len; i++) { //TODO ++i
            if (dp[(1 << len) - 1][i] > dp[(1 << len) - 1][p])
                p = i;
        }

        while (p != -1) {
            perm[t++] = p;
            seen[p] = true;
            int p2 = parent[mask][p];
            mask ^= 1 << p;
            p = p2;
        }

        for (int i = 0; i < t / 2; i++) { //TODO ++i
            int v = perm[i];
            perm[i] = perm[t - 1 - i];
            perm[t - 1 - i] = v;
        }

        for (int i = 0; i < len; i++) { //TODO ++i
            if (!seen[i]) perm[t++] = i;
        }

        StringBuilder answer = new StringBuilder(words[perm[0]]);
        for (int i = 1; i < len; i++) { //TODO ++i
            int overlap = overlaps[perm[i - 1]][perm[i]];
            answer.append(words[perm[i]].substring(overlap));
        }

        return answer.toString();
    }
}

class FindTheShortestSuperStringSolution1 {
    public String shortestSuperstring(String[] A) {
        if (A.length == 0) return "";
        if (A.length == 1) return A[0];
        if (A.length < 6) return shortestSuperstring2(A);
        int n = A.length;
        while (n > 1) {
            String o = "";
            int maxL = 0;
            int l = 0, r = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    String m1 = merge(A[i], A[j]), m2 = merge(A[j], A[i]);
                    String m;
                    if (m1.length() < m2.length()) m = m1;
                    else m = m2;
                    int ll = A[i].length() + A[j].length() - m.length();
                    if (ll > maxL) {
                        maxL = ll;
                        o = m;
                        l = i;
                        r = j;
                    }
                }
            }
            n--;
            if (maxL == 0) {
                A[0] += A[n];
            } else {
                A[l] = o;
                A[r] = A[n];
            }
        }
        return A[0];
    }

    private String merge(String a, String b) {
        int i = 0;
        while (i < a.length()) {
            String suf = a.substring(i, a.length());
            if (isPrefix(suf, b)) {
                return a.substring(0, i) + b;
            }
            i++;
        }
        return a + b;
    }

    private boolean isPrefix(String p, String b) {
        if (p.length() > b.length()) return false;
        int i = 0, j = 0;
        while (i < p.length()) {
            if (p.charAt(i++) != b.charAt(j++)) return false;
        }
        return true;
    }


    public String shortestSuperstring2(String[] A) {
        if (A.length == 0) return "";
        List<List<String>> all = permute(A);
        int minL = Integer.MAX_VALUE;
        String ans = null;
        for (List<String> b : all) {
            String last = b.get(0);
            for (int i = 1; i < b.size(); i++) last = merge(last, b.get(i));
            if (last.length() < minL) {
                minL = last.length();
                ans = last;
            }
        }
        return ans;
    }

    private List<List<String>> permute(String[] A) {
        List<List<String>> res = new ArrayList<>();
        permute(A, res, new ArrayList<String>(), new boolean[A.length]);
        return res;
    }

    private void permute(String[] A, List<List<String>> res, List<String> tmp, boolean[] used) {
        if (tmp.size() == A.length) {
            res.add(new ArrayList(tmp));
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            tmp.add(A[i]);
            permute(A, res, tmp, used);
            used[i] = false;
            tmp.remove(tmp.size() - 1);
        }
    }
}

class FindTheShortestSuperStringSolution2 {

    int min = Integer.MAX_VALUE;
    String ans = "";
    int[][] into;
    boolean[] visited;

    private int merge(String a, String b) {
        int lim = Math.min(a.length(), b.length());
        for (int len = lim; len > 0; len--) {
            if (b.startsWith(a.substring(a.length() - len)))
                return len;
        }
        return 0;
    }

    private void dfs(int cnt, int last, StringBuilder sb, String[] A) {
        int tmp = sb.length();
        for (int i = 0; i < A.length; i++) {
            if (visited[i]) continue;
            tmp += A[i].length();
            int miss = 0;
            for (int j = 0; j < A.length; j++)
                miss = Math.max(miss, into[j][i]);
            tmp -= miss;
        }
        if (tmp >= min) return;

        if (cnt == A.length) {
            if (sb.length() >= min) return;
            min = sb.length();
            ans = sb.toString();
            return;
        }

        int len = sb.length();
        for (int i = 0; i < A.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            tmp = last > -1 ? into[last][i] : 0;
            sb.append(A[i].substring(tmp));
            dfs(cnt + 1, i, sb, A);
            sb.setLength(len);
            visited[i] = false;
        }
    }

    public String shortestSuperstring(String[] A) {
        int n = A.length;
        into = new int[n][n];

        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A.length; j++) {
                if (i == j) continue;
                into[i][j] = merge(A[i], A[j]);

            }

        visited = new boolean[A.length];
        dfs(0, -1, new StringBuilder(), A);
        return ans;
    }
}