package problems;

public class P374_Guess_Number_Higher_or_Lower {
    public static void main(String[] args) {

    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0) return mid;
            else if (res < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private int guess(int mid) {
        return 0;
    }
}
