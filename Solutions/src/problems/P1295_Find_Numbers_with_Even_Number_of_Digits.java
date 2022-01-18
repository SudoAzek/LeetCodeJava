package problems;

public class P1295_Find_Numbers_with_Even_Number_of_Digits {
    public static void main(String[] args) {
        P1295_Find_Numbers_with_Even_Number_of_Digits sol = new P1295_Find_Numbers_with_Even_Number_of_Digits();
        System.out.println(sol.findNumbers(new int[]{555, 901, 482, 1771}));
    }

    public int findNumbers(int[] nums) {
        int count = 0, digitCount;

        for (int number : nums) {
            digitCount = 0;
            while (number > 0) {
                digitCount++;
                number = number / 10;
            }
            if (digitCount % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public int findNumbers2(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int val = (int) Math.log10(num);
            if ((val + 1) % 2 == 0) count++;
        }
        return count;
    }
}
