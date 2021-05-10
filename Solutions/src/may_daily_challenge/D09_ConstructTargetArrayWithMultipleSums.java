package may_daily_challenge;

import java.util.PriorityQueue;
import java.util.Queue;

public class D09_ConstructTargetArrayWithMultipleSums {
    public static void main(String[] args) {

    }
}

class ConstructTargetArrayWithMultipleSumsSolution {
    public boolean isPossible(int[] target) {
        Queue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int num : target) {
            sum += num;
            priorityQueue.add(num);
        }
        while (priorityQueue.peek() != 1) {
            int num = priorityQueue.poll();
            sum -= num;
            if (num <= sum || sum < 1) return false;
            num %= sum;
            sum += num;
            priorityQueue.add(num > 0 ? num : sum);
        }
        return true;
    }
}

class ConstructTargetArrayWithMultipleSumsSolution2 {
    public boolean isPossible(int[] target) {
        int len = target.length;
        if (len == 1) {
            return target[0] == 1;
        }
        long sum = 0L;
        long max = 0L;
        int maxIdx = -1;
        for (int i = 0; i < len; i++) {
            long cur = (long) target[i];
            sum += cur;
            if (cur > max) {
                max = cur;
                maxIdx = i;
            }
        }

        if (sum == (long) len) {
            return true;
        }

        long o = sum - max;
        long x = max % o;
        if (x == 0L) {
            x = o;
        }

        if (x == max) {
            return false;
        }

        target[maxIdx] = (int) x;
        return isPossible(target);
    }
}

class ConstructTargetArrayWithMultipleSumsSolution3 {
    public boolean isPossible(int[] target) {
        if (target.length == 1) return target[0] == 1;
        while (true) {
            long sum = 0;
            int max = Integer.MIN_VALUE;
            int maxId = -1;
            for (int i = 0; i < target.length; i++) {
                int num = target[i];
                sum += num;
                if (num > max) {
                    max = num;
                    maxId = i;
                }

            }
            if (sum == target.length) return true;
            long prev = max % (sum - max);
            if (prev == 0) prev = sum - max;

            if (prev == max) return false;
            target[maxId] = (int) prev;

        }
    }
}
