package february_daily_challenge;

import java.util.HashMap;

public class D20_RomanToInteger {
    public static void main(String[] args) {
        RomanToIntegerSolution solution = new RomanToIntegerSolution();
        System.out.println(solution.romanToInt("MDCCLX"));
    }
}

class RomanToIntegerSolution {
    public int romanToInt(String s) {
        int sum = 0;

        int n = s.length();
        for (int i = n - 1; i >= 0; i--){
            char ch = s.charAt(i);
            switch (ch){
                case 'I': sum += sum >= 5? -1 : 1; break;
                case 'V': sum += 5; break;
                case 'X': sum += sum >= 50? -10: 10; break;
                case 'L': sum += 50; break;
                case 'C': sum += sum >= 500? -100: 100; break;
                case 'D': sum += 500; break;
                case 'M': sum += 1000; break;

            }
        }
        return sum;
    }
}

class RomanToIntegerSolution_1 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> romanMap = new HashMap<>();

        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int res = 0, i = -1, n = s.length();;
        while (++i < n) {
            if(i > 0 && romanMap.get(s.charAt(i)) > romanMap.get(s.charAt(i - 1)))
                res += romanMap.get(s.charAt(i)) - 2 * romanMap.get(s.charAt(i - 1));
            else
                res += romanMap.get(s.charAt(i));
        }
        return res;
    }
}
