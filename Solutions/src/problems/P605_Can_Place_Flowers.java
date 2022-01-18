package problems;

public class P605_Can_Place_Flowers {
    public static void main(String[] args) {

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeros = 1, answer = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                zeros++;
            } else {
                answer += (zeros - 1) / 2;
                zeros = 0;
            }
        }
        return answer + zeros / 2 >= n;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        if (n == 0) return true;

        int spotCount = 0, len = flowerbed.length;

        int i = 0;
        while (i < len) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                spotCount++;
                i += 2;
                if (spotCount == n) return true;
            } else i++;
        }
        return false;
    }

}
