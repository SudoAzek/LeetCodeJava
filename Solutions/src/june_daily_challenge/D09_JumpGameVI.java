package june_daily_challenge;

import java.util.LinkedList;

public class D09_JumpGameVI {
    public static void main(String[] args) {
        JumpGameVISolution jumpGameVISolution = new JumpGameVISolution();
        System.out.println(jumpGameVISolution.maxResult(new int[]{1, -1, -2, 4, -7, 3}, 2));
    }
}

class JumpGameVISolution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length, a = 0, b = 0;
        int[] deq = new int[n];
        deq[0] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (deq[a] - i > k) a++;
            nums[i] += nums[deq[a]];
            while (b >= a && nums[deq[b]] <= nums[i]) b--;
            deq[++b] = i;
        }
        return nums[0];
    }
}


class JumpGameVISolution2 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int j = 1, i = 0;

        LinkedList<Integer> q = new LinkedList<>();
        while (j < n) {
            while (!q.isEmpty() && q.peekLast() < dp[j - 1])
                q.pollLast();
            q.offer(dp[j - 1]);
            int max = q.peek();
            dp[j] = max + nums[j];
            if (j - i == k) {
                if (dp[i] == q.peek())
                    q.poll();
                i++;
            }
            j++;
        }
        return dp[n - 1];
    }
}