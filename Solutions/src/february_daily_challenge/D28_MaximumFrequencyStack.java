package february_daily_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class D28_MaximumFrequencyStack {
    public static void main(String[] args) {
        /**
         * Your FreqStack object will be instantiated and called as such:
         */
         FreqStack obj = new FreqStack();
        int param_2 = obj.pop();
        obj.push(param_2);

    }
}

class FreqStack {
    HashMap<Integer, Integer> frequency = new HashMap<>();
    HashMap<Integer, Stack<Integer>> hashMap = new HashMap<>();
    int maxFrequency = 0;

    public void push(int x) {
        int f = frequency.getOrDefault(x, 0) + 1;
        frequency.put(x, f);
        maxFrequency = Math.max(maxFrequency, f);
        if (!hashMap.containsKey(f)) hashMap.put(f, new Stack<Integer>());
        hashMap.get(f).add(x);
    }

    public int pop() {
        int x = hashMap.get(maxFrequency).pop();
        frequency.put(x, maxFrequency - 1);
        if (hashMap.get(maxFrequency).size() == 0) maxFrequency--;
        return x;
    }
}

class FreqStack2 {
    ArrayList<ArrayList<Integer>> groups;
    HashMap<Integer, Integer> freqs;
    int maxFreq;

    public FreqStack2() {
        freqs = new HashMap<>();
        groups = new ArrayList<>();
        groups.add(new ArrayList<>());
        maxFreq = 0;
    }

    public void push(int x) {
        var freq = freqs.getOrDefault(x, 0) + 1;
        freqs.put(x, freq);
        if (groups.size() <= freq) {
            groups.add(new ArrayList<>());
        }
        groups.get(freq).add(x);
        maxFreq = Math.max(freq, maxFreq);
    }

    public int pop() {
        var group = groups.get(maxFreq);
        var x = group.remove(group.size() - 1);
        freqs.put(x, maxFreq - 1);
        maxFreq -= group.isEmpty() ? 1 : 0;
        return x;
    }
}

