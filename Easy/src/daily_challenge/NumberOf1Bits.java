package daily_challenge;

public class NumberOf1Bits {
    public static void main(String[] args) {
        NumberOf1BitsSolution_1 numberOf1BitsSolution_1 = new NumberOf1BitsSolution_1();

        System.out.println(numberOf1BitsSolution_1.hammingWeight(0b00000000000000000000000000001011));
//        numberOf1BitsSolution.hammingWeight(0b11111111111111111111111111111111);
    }
}

class NumberOf1BitsSolution_1 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        char[] s = Integer.toBinaryString(n).toCharArray();
        int sum = 0;
        for (char c : s) {
            if (c == '1')
                sum += 1;
        }
        return sum;
    }
}
