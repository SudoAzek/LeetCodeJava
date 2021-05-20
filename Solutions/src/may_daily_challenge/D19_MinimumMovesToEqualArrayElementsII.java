package may_daily_challenge;

import java.util.Arrays;

public class D19_MinimumMovesToEqualArrayElementsII {
    public static void main(String[] args) {
        MinimumMovesToEqualArrayElementsIISolution solution = new MinimumMovesToEqualArrayElementsIISolution();
        System.out.println(solution.minMoves2(new int[]{0, 1, 6, 8}));
    }
}

class MinimumMovesToEqualArrayElementsIISolution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int answer = 0, median = nums[nums.length / 2];
        for (int num : nums) {
            answer += Math.abs(median - num);
        }
        return answer;
    }
}

// Wrong solution
class MinimumMovesToEqualArrayElementsIISolution3 {
    public int minMoves2(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int answer = 0, median = sum / nums.length;
        for (int num : nums) {
            answer += Math.abs(median - num);
        }
        return answer;
    }
}

class MinimumMovesToEqualArrayElementsIISolution2 {
    public int minMoves2(int[] nums) {
        int median = quickSelect(nums.length / 2, 0, nums.length - 1, nums);
        int sum = 0;
        for (int num : nums) {
            sum += Math.abs(num - median);
        }
        return sum;
    }

    private int quickSelect(int k, int left, int right, int[] nums) {
        if (left == right) return nums[left];
        int pivot = nums[(left + right) >>> 1];
        int l = left, r = right;
        while (l <= r) {
            while (l <= r && nums[l] < pivot) l++;
            while (l <= r && nums[r] > pivot) r--;
            if (l < r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            } else break;
            l++;
            r--;
        }
        if (nums[l] > pivot) l--;
        if (l >= k) {
            if (l == k && left + 1 == l) {
                return Math.max(nums[left], nums[l]);
            }
            return quickSelect(k, left, l, nums);
        }
        return quickSelect(k, l + 1, right, nums);
    }
}