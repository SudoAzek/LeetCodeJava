package problems;

public class P258_Add_Digits {
    public static void main(String[] args) {
        System.out.println(addDigits(0));
    }


    public static int addDigits(int num) {
        int sum = Integer.MAX_VALUE;
        while (sum > 9) {
            sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return sum;
    }

    public int addDigits2(int num) {
        while (num > 9) {
            int sum = 0;
            while (num >= 1) {
                sum += (num % 10);
                num /= 10;
            }
            num = sum;
        }
        return num;
    }

    public int addDigits3(int num) {
        if (num == 0) {
            return 0;
        }
        return (num % 9 == 0) ? 9 : num % 9;
    }
}
