package march_daily_challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class D19_KeysAndRooms {
    public static void main(String[] args) {
        KeysAndRoomsSolution solution = new KeysAndRoomsSolution();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<Integer>());
        System.out.println(solution.canVisitAllRooms(rooms));
    }
}

class KeysAndRoomsSolution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        while (!stack.isEmpty()) {
            List<Integer> keys = rooms.get(stack.pop());
            for (int key : keys) {
                if (!visited.contains(key)) {
                    visited.add(key);
                    stack.add(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }
}