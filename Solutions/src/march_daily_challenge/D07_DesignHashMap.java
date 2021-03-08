package march_daily_challenge;

import java.util.Arrays;

public class D07_DesignHashMap {
    public static void main(String[] args) {
        MyHashMapWithArray hashMap = new MyHashMapWithArray();
        hashMap.put(1994, 17);
        System.out.println(hashMap.get(1994));
    }
}

class MyHashMapWithArray {
    int[] map = null;
    /** Initialize your data structure here. */
    public MyHashMapWithArray() {
        map = new int[1000001];
        Arrays.fill(map, -1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        put(key, -1);
    }
}

class ListNode {
    int key, val;
    ListNode next;

    public ListNode(int key, int value, ListNode next) {
        this.key = key;
        this.val = value;
        this.next = next;
    }
}

class MyHashMapWithHash {
    static final int size = 19997;
    static final int mult = 12582917;
    ListNode[] data;

    /**
     * Initialize your data structure here.
     */
    public MyHashMapWithHash() {
        this.data = new ListNode[size];
    }

    private int hash(int key) {
        return (int) ((long) key * mult % size);
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        remove(key);
        int h = hash(key);
        ListNode node = new ListNode(key, value, data[h]);
        data[h] = node;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int h = hash(key);
        ListNode node = data[h];
        for (; node != null; node = node.next)
            if (node.key == key) return node.val;
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int h = hash(key);
        ListNode node = data[h];
        if (node == null) return;
        if (node.key == key) data[h] = node.next;
        else for (; node.next != null; node = node.next)
            if (node.next.key == key) {
                node.next = node.next.next;
                return;
            }
    }
}

class MyHashMap {
    private int[] map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[100001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value + 1;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key] - 1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */