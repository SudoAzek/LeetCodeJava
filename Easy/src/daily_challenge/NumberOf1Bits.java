package daily_challenge;

public class NumberOf1Bits {
    public static void main(String[] args) {
        NumberOf1BitsSolution_1 numberOf1BitsSolution_1 = new NumberOf1BitsSolution_1();
        NumberOf1BitsSolution_2 numberOf1BitsSolution_2 = new NumberOf1BitsSolution_2();
        NumberOf1BitsSolution_3 numberOf1BitsSolution_3 = new NumberOf1BitsSolution_3();

        System.out.println(numberOf1BitsSolution_1.hammingWeight(0b1011));
        System.out.println(numberOf1BitsSolution_2.hammingWeight(0b1011));
        System.out.println(numberOf1BitsSolution_3.hammingWeight(0b1011));
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

class NumberOf1BitsSolution_2 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}

class NumberOf1BitsSolution_3 {
    public int hammingWeight(int n) {
        long num = n & 0xFFFFFFFFL;
        int count = 0;
        while (num != 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}

