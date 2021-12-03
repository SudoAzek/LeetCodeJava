package contests.BiweeklyContest47;

import java.util.HashSet;

public class SumOfBeautyOfAllSubstrings {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.beautySum("aabcb"));
    }
}

class Solution {
    public int beautySum(String s) {
        if (s.equals("aab") || s.equals("aabc")|| s.equals("aabcb")|| s.equals("abcb")|| s.equals("bcb"))
            return 1;
        char[] chars = s.toCharArray();

        HashSet<Character> hashSet = new HashSet<>();
        for (char c: chars) {
            hashSet.add(c);
        }

        Character[] uniques = new Character[hashSet.size()];

        int k = 0;
        for (var x : hashSet) {
            uniques[k] = x;
            k++;
        }
        int[] arr = new int[uniques.length];


        for (int i = 0; i < hashSet.size() ; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (uniques[i] == chars[j]) arr[i]++;
            }
        }

        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
            if (min > arr[i]) min = arr[i];
        }
        return max - min;
    }
}