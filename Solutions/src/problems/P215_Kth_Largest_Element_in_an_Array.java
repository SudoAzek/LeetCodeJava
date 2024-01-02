package problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class P215_Kth_Largest_Element_in_an_Array {
    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.add(num);
        }

        while (k > 1) {
            maxHeap.poll();
            k--;
        }

        return maxHeap.peek();
    }
    public int findKthLargest2(int[] nums, int k) {

        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for(int val : nums) {
            maxHeap.offer(val);

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
