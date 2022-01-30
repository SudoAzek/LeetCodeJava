package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P119_Pascals_Triangle_II {
    public static void main(String[] args) {

    }

    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        Arrays.fill(result, 0);
        result[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++)
            for (int j = i; j >= 1; j--)
                result[j] += result[j - 1];
        return Arrays.asList(result);
    }

    public List<Integer> getRow2(int rowIndex) {
        long nCk = 1;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; i++) {
            result.add((int) nCk);
            nCk = nCk * (rowIndex - i) / (i + 1);
        }
        return result;
    }
}
