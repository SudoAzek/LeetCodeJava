package fun_with_arrays.introduction.problems;

public class FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
        FindNumbersWithEvenNumberOfDigitsSolution sol = new FindNumbersWithEvenNumberOfDigitsSolution();
        System.out.println(sol.findNumbers(new int[]{12, 345, 2, 6, 7896}));
    }
}

class FindNumbersWithEvenNumberOfDigitsSolution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int n = counts(num);
            if (n % 2 == 0) count++;
        }
        return count;
    }

    int counts(int number) {
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }
}

class FindNumbersWithEvenNumberOfDigitsSolution_2 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int n = (int) (Math.log10(num) + 1);
            if (n % 2 == 0) count++;
        }
        return count;
    }
}

class FindNumbersWithEvenNumberOfDigitsSolution_3 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int number : nums) {
            if (isEvenNumberDigits(number))
                count++;
        }
        return count;
    }

    private boolean isEvenNumberDigits(int num) {
        return (num / 10 > 0 && num / 10 < 10) || (num / 1_000 > 0 && num / 1_000 < 10) || (num / 1_00_000 > 0 && num / 1_00_000 < 10);
    }
}
