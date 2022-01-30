package problems;

public class P1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
}


class Solution_Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        int result = 0;
        for (int t :
                time) {
            result += arr[(600 - t) % 60];
            arr[t % 60] += 1;
        }
        return result;
    }
}

class Solution_Pairs_of_Songs_With_Total_Durations_Divisible_by_60_2 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainder = new int[time.length];
        for (int i = 0; i < time.length; i++) {
            remainder[i] = time[i] % 60;
        }

        int[] remainder_frequency = new int[60];
        for (int rem : remainder) {
            remainder_frequency[rem]++;
        }
        int count = 0;
        for (int key = 0; key <= 30; key++) {
            if (key == 0 || key == 30) {
                count += (remainder_frequency[key] * (remainder_frequency[key] - 1)) / 2;
            } else {
                count += remainder_frequency[key] * remainder_frequency[60 - key];
            }
        }

        return count;
    }
}