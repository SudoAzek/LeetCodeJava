package problems;

public class P1486_XOR_Operation_in_an_Array {
    public static void main(String[] args) {
        Solution_XOR_Operation_in_an_Array sol = new Solution_XOR_Operation_in_an_Array();
        System.out.println(sol.xorOperation(5, 0));
    }
}

class Solution_XOR_Operation_in_an_Array {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = start + 2 * i;
        }

        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        return xor;
    }
}

class Solution_XOR_Operation_in_an_Array2 {
    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res = res ^ (start + 2 * i);
        }

        return res;
    }
}