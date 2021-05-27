package may_daily_challenge;

import java.util.Arrays;

public class D26_PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public static void main(String[] args) {
        PartitioningIntoMinimumNumberOfDeciBinaryNumbersSolution solution = new PartitioningIntoMinimumNumberOfDeciBinaryNumbersSolution();
        System.out.println(solution.minPartitions("1994"));
    }
}

class PartitioningIntoMinimumNumberOfDeciBinaryNumbersSolution {
    public int minPartitions(String n) {
        char best = '0';
        for (var c : n.toCharArray()) {
            if (c > best) best = c;
        }
        return best - '0';
    }
}

//class PartitioningIntoMinimumNumberOfDeciBinaryNumbersSolution1 {
//    public int minPartitions(String n) {
//        char[] chars = n.toCharArray();
//        return Character
//    }
//}

class PartitioningIntoMinimumNumberOfDeciBinaryNumbersSolution2 {
    public int minPartitions(String n) {
        int length = Math.min(n.length(), 10);
        int max = n.charAt(0) - 48;
        for (int i = 1; i < length; i++) {
            if (n.charAt(i) - 48 > max) {
                max = n.charAt(i) - 48;
            }
        }
        return max;
    }
}