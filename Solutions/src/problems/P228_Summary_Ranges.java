package problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class P228_Summary_Ranges {
    public static void main(String[] args) {
        Summary_Ranges_Solution solution = new Summary_Ranges_Solution();
        System.out.println(solution.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }

}


class Summary_Ranges_Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new LinkedList<>();
        int len = nums.length;

        if (len == 1) {
            res.add(nums[0] + "");
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            while (i + 1 < nums.length && (nums[i + 1] - nums[i] == 1)) {
                i++;
            }
            if (start != nums[i]) {
                res.add(start + "->" + nums[i]);
            } else {
                res.add(start + "");
            }
        }
        return res;
    }

    public List<String> summaryRanges2(int[] nums) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int n = nums.length;
        if (n == 0) {
            return res;
        }
        int start = nums[0];
        for (int i = 0; i < n - 1; i++) {
            if (sb.length() == 0) {
                start = nums[i];
                sb.append(start);
            }
            if (nums[i + 1] != nums[i] + 1) {
                int end = nums[i];
                if (start != end) {
                    sb.append("->");
                    sb.append(end);
                }
                res.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() == 0) {
            res.add(Integer.toString(nums[n - 1]));
        } else {
            sb.append("->");
            sb.append(nums[n - 1]);
            res.add(sb.toString());
        }

        return res;
    }
}