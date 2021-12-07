package problems;

public class P1281_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer {
    public static void main(String[] args) {
        Solution_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer sol = new Solution_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer();
        System.out.println(sol.subtractProductAndSum(234));
    }
}

class Solution_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer {
    public int subtractProductAndSum(int n) {
        int len = String.valueOf(n).length();
        int rem;
        int product = 1, sum = 0;
        for (int i = 0; i < len; i++) {
            rem = n % 10;
            product *= rem;
            sum += rem;
            n /= 10;
        }

        return product - sum;
    }
}
