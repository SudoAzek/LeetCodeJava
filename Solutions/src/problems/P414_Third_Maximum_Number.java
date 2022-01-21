package problems;

public class P414_Third_Maximum_Number {
    public static void main(String[] args) {

    }
}

class Solution_Third_Maximum_Number {
    public int thirdMax(int[] nums) {
        long fMax = Long.MIN_VALUE, sMax = Long.MIN_VALUE, tMax = Long.MIN_VALUE;

        for (int num : nums) {
            if (fMax == num || sMax == num || tMax == num) continue;
            if (num > fMax) {
                tMax = sMax;
                sMax = fMax;
                fMax = num;
            } else if (num > sMax) {
                tMax = sMax;
                sMax = num;
            } else if (num > tMax) {
                tMax = num;
            }
        }
        return (int) (tMax == Long.MIN_VALUE ? fMax : tMax);
    }
}