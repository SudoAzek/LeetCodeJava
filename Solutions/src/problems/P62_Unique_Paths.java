package problems;

public class P62_Unique_Paths {
    public static void main(String[] args) {
        System.out.println(uniquePath_math(7, 3));

    }

    static int uniquePath_math(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
