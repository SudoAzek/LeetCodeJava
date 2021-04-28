package april_daily_challenge;

import java.util.PriorityQueue;

public class D26_FurthestBuildingYouCanReach {
}

class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            int diff = heights[i+1] - heights[i];
            if (diff > 0) {
                if (ladders > 0) {
                    pq.add(diff);
                    ladders--;
                } else if (pq.size() > 0 && diff > pq.peek()) {
                    pq.add(diff);
                    bricks -= pq.poll();
                } else bricks -= diff;
                if (bricks < 0) return i;
            }
        }
        return len;
    }
}

class FurthestBuildingYouCanReach1 {
    public int furthestBuilding(int[] H, int B, int L) {
        int len = H.length - 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            int diff = H[i+1] - H[i];
            if (diff > 0) {
                if (L > 0) {
                    pq.add(diff);
                    L--;
                } else if (pq.size() > 0 && diff > pq.peek()) {
                    pq.add(diff);
                    B -= pq.poll();
                } else B -= diff;
                if (B < 0) return i;
            }
        }
        return len;
    }
}
