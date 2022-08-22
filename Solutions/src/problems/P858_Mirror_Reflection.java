package problems;

public class P858_Mirror_Reflection {
    public static void main(String[] args) {
        Solution_Mirror_Reflection solution = new Solution_Mirror_Reflection();
        System.out.println(solution.mirrorReflection(2, 1));
    }
}

class Solution_Mirror_Reflection {
    public int mirrorReflection(int p, int q) {
        while (p % 2 == 0 && q % 2 == 0) {
            p >>= 1; q >>= 1;
        }
        return 1 - p % 2 + q % 2;
    }
}