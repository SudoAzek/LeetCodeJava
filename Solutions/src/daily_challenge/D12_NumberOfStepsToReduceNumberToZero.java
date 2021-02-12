package daily_challenge;

public class D12_NumberOfStepsToReduceNumberToZero {
    public static void main(String[] args) {
        NumberOfStepsToReduceNumberToZeroSolution sol = new NumberOfStepsToReduceNumberToZeroSolution();
        NumberOfStepsToReduceNumberToZeroSolution_1 sol1 = new NumberOfStepsToReduceNumberToZeroSolution_1();
        NumberOfStepsToReduceNumberToZeroSolution_2 sol2 = new NumberOfStepsToReduceNumberToZeroSolution_2();
        System.out.println(sol.numberOfSteps(8));
        System.out.println(sol1.numberOfSteps(8));
        System.out.println(sol2.numberOfSteps(8));
    }

}

class NumberOfStepsToReduceNumberToZeroSolution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= num % 2;
            }
            count++;
        }
        return count;
    }
}

class NumberOfStepsToReduceNumberToZeroSolution_1 {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num--;
            }
            count++;
        }
        return count;
    }
}

class NumberOfStepsToReduceNumberToZeroSolution_2 {
    public int numberOfSteps(int num) {
        if (num < 4) {
            return num;
        }
        return numberOfSteps(num >> 1) + (((num & 1) == 1) ? 2 : 1);
    }
}