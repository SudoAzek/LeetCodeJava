package problems;

import java.util.HashMap;
import java.util.HashSet;

public class P1346_Check_If_N_and_Its_Double_Exist {
    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{0, 0}));
        // -2, 0, 10, -19, 4, 6, -8
    }

    public static boolean checkIfExist(int[] arr) {
        if (arr.length == 1 || arr == null) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(2 * num) || (num % 2 == 0 && set.contains(num / 2)) ) return true;
            set.add(num);
        }
        return false;
    }
}
