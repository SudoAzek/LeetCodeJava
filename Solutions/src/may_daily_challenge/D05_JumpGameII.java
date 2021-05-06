package may_daily_challenge;

public class D05_JumpGameII {
    public static void main(String[] args) {
        JumpGameIISolution solution = new JumpGameIISolution();
        System.out.println(solution.jump(new int[]{2, 3, 1, 1, 4}));
    }
}

class JumpGameIISolution {
    public int jump(int[] nums) {
        int len = nums.length - 1;
        int curr = -1;
        int next = 0;
        int answer = 0;
        for (int i = 0; next < len; i++) {
            if (i > curr) {
                answer++;
                curr = next;
            }
            next = Math.max(next, nums[i] + i);
        }
        return answer;
    }
}