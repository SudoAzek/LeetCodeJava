package march_daily_challenge;

import java.util.HashSet;

public class D01_DistributeCandies {
    public static void main(String[] args) {
        DistributeCandiesSolution sol = new DistributeCandiesSolution();
        int[] candies = new int[]{1,1,2,2,3,3};
        System.out.println(sol.distributeCandies(candies));

    }
}

class DistributeCandiesSolution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> distinctCandies = new HashSet<>();

        for (int type : candyType) {
            distinctCandies.add(type);
        }
        return Math.min(candyType.length / 2, distinctCandies.size());
    }
}

class DistributeCandiesSolution2 {
    public int distributeCandies(int[] candies) {
        int candiesToEat = candies.length / 2;
        int typeCount = 0;
        boolean[] typeUsed = new boolean[200001];
        for (int c: candies) {
            int t = c + 100000;
            if (!typeUsed[t]) {
                if (++typeCount >= candiesToEat)  return candiesToEat;
                typeUsed[t] = true;
            }
        }
        return typeCount;
    }
}