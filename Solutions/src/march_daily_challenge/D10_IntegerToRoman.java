package march_daily_challenge;

public class D10_IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRomanSolution solution = new IntegerToRomanSolution();
        System.out.println(solution.intToRoman(1994));
    }
}

class IntegerToRomanSolution {
    int[] ints = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int nums) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; nums > 0; i++) {
            while (nums >= ints[i]) {
                answer.append(romans[i]);
                nums -= ints[i];
            }
        }
        return answer.toString();
    }
}