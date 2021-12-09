package problems;

import java.util.Arrays;

public class P1720_Decode_XORed_Array {
    public static void main(String[] args) {
        Solution_Decode_XORed_Array sol = new Solution_Decode_XORed_Array();
        System.out.println(Arrays.toString(sol.decode(new int[]{1, 2, 3}, 1)));
    }
}

class Solution_Decode_XORed_Array {
    public int[] decode(int[] encoded, int first) {
        int[] decoded = new int[encoded.length + 1];
        decoded[0] = first;

        for (int i = 1; i < decoded.length; i++) {
            decoded[i] = encoded[i - 1] ^ decoded[i - 1];
        }

        return decoded;
    }
}

class Solution_Decode_XORed_Array2 {
    public int[] decode(int[] encoded, int first) {
        int[] answer = new int[encoded.length + 1];
        answer[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            answer[i + 1] = encoded[i] ^ answer[i];
        }
        return answer;
    }
}