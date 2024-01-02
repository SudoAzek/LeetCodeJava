package problems;

import java.util.LinkedList;
import java.util.Queue;

public class P622_Design_Circular_Queue {
    public static void main(String[] args) {
        int size = 6, value = 11;
        MyCircularQueue queue = new MyCircularQueue(size);
        System.out.println("The first element is: " + queue.Front());
        // 3. Push new element.
        queue.enQueue(5);
        queue.enQueue(13);
        queue.enQueue(8);
        queue.enQueue(6);
        // 4. Pop an element.
        queue.deQueue();
        // 5. Get the first element.
        System.out.println("The first element is: " + queue.Front());
        // 7. Get the size of the queue.
//        System.out.println("The size is: " + q.Rear());


        System.out.println();
        // 1. Initialize a queue.
        Queue<Integer> q = new LinkedList();
        // 2. Get the first element - return null if queue is empty.
        System.out.println("The first element is: " + q.peek());
        // 3. Push new element.
        q.offer(5);
        q.offer(13);
        q.offer(8);
        q.offer(6);
        // 4. Pop an element.
        q.poll();
        // 5. Get the first element.
        System.out.println("The first element is: " + q.peek());
        // 7. Get the size of the queue.
        System.out.println("The size is: " + q.size());
    }

}

class MyCircularQueue {
    int[] data;
    int front;
    int rear;
    boolean noElement;

    public MyCircularQueue(int k) {
        this.data = new int[k];
        this.noElement = true;
    }

    public boolean enQueue(int value) {
        if (!this.isFull()) {
            data[rear] = value;
            this.noElement = false;
            rear++;
            rear = rear % data.length;
            return true;
        } else {
            return false;
        }
    }

    public boolean deQueue() {
        if (!this.isEmpty()) {
            front++;
            front = front % data.length;
            if (front == rear) this.noElement = true;
            return true;
        } else {
            return false;
        }
    }

    public int Front() {
        if (!this.isEmpty()) {
            return data[front];
        } else {
            return -1;
        }
    }

    public int Rear() {
        if (!this.isEmpty()) {
            if (rear == 0) {
                return data[data.length - 1];
            } else {
                return data[rear - 1];
            }
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return this.noElement;
    }

    public boolean isFull() {
        return (front == rear) && !this.noElement;
    }
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */