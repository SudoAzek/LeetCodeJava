package problems;

public class P845_Longest_Mountain_in_Array {
    public static void main(String[] args) {
        Solution_Longest_Mountain_in_Array sol = new Solution_Longest_Mountain_in_Array();
        System.out.println(sol.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }
}

class Solution_Longest_Mountain_in_Array {
    public int longestMountain(int[] arr) {
        int result = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i;
                int right = i;
                while (left > 0 && arr[left] > arr[left - 1]) left--;
                while (right + 1 < arr.length && arr[right] > arr[right + 1]) right++;
                result = Math.max(result, right - left + 1);
            }
        }
        return result;
    }
}