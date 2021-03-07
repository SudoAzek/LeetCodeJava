package easy;

public class P13_Roman_To_Integer {
    public static void main(String[] args) {
        RomanToIntSolution romanToIntSolution = new RomanToIntSolution();
        System.out.println(romanToIntSolution.romanToInt("III"));
    }
}

class RomanToIntSolution {
    public int romanToInt(String s) {
        int num = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == 'I'){
                num++;
            }

            if(s.charAt(i) == 'V') {
                System.out.print(5);
            }
        }
        return num;
    }
}
