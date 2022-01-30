package problems;

public class P69_SqrtX {
    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left) / 2;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) return mid;
                left = mid + 1;
            }
        }
    }

    public int mySqrt2(int x) {
        if (x < 2) return x;

        int left = 2;
        int right = x / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long current = ((long) mid) * mid;

            if (current > x) {
                right = mid - 1;
            } else if (current < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return right;
    }
}
