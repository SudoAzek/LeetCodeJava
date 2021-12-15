package problems;

public class P461_Hamming_Distance {
    public static void main(String[] args) {
        Solution_Hamming_Distance sol = new Solution_Hamming_Distance();
        Solution_Hamming_Distance2 sol2 = new Solution_Hamming_Distance2();
        System.out.println(sol.hammingDistance(1, 4));
        System.out.println(sol2.hammingDistance(1, 4));
    }
}

class Solution_Hamming_Distance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}

class Solution_Hamming_Distance2 {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1;
        }
        return count;
    }
}