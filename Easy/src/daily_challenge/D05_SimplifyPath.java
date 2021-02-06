package daily_challenge;

import java.util.Deque;
import java.util.LinkedList;

public class D05_SimplifyPath {
    public static void main(String[] args) {

    }
}

class Solution {
    public String simplifyPath(String path) {
        String[] elements = path.split("/");
        Deque<String> folders = new LinkedList<>();
        for(String element : elements) {
            if(element.equals("..")) {
                if (!folders.isEmpty()) folders.removeLast();
                continue;
            }
                if(element.equals(".") || element.isEmpty()) continue;
                folders.add(element);

        }
        return "/" + String.join("/", folders);
    }
}
