package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P118_Pascals_Triangle {
    public static void main(String[] args) {
        Solution_Pascals_Triangle sol = new Solution_Pascals_Triangle();
        System.out.println(sol.generate(5));
    }
}

class Solution_Pascals_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();


        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            triangle.add(new ArrayList<>(row));
        }
        return triangle;
    }
}
