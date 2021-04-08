package april_daily_challenge;

public class D07_DetermineIfStringHalvesAreAlike {
    public static void main(String[] args) {
        DetermineIfStringHalvesAreAlikeSolution solution = new DetermineIfStringHalvesAreAlikeSolution();
        System.out.println(solution.halvesAreAlike("book"));
    }
}

class DetermineIfStringHalvesAreAlikeSolution {
    String vows = "aeiouAEIOU";
    public boolean halvesAreAlike(String s) {
        int mid = s.length() / 2, ans = 0;
        for (int i = 0, j = mid; i < mid; i++, j++) {
            if (vows.indexOf(s.charAt(i)) >= 0) ans++;
            if (vows.indexOf(s.charAt(j)) >= 0) ans--;
        }
        return ans == 0;
    }
}