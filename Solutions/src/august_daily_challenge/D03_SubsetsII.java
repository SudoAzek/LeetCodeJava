package august_daily_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D03_SubsetsII {
    public static void main(String[] args) {
        SubsetsIISolution solution = new SubsetsIISolution();
        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
    }
}

class SubsetsIISolution {
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList();
        backTracking(0, nums, new ArrayList());
        return res;
    }

    public void backTracking(int index, int[] nums, List<Integer> list) {
        res.add(new ArrayList(list));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            backTracking(i + 1, nums, list);
            list.remove(list.size() - 1);
        }
    }
}