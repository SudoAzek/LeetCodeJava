package february_daily_challenge;

import java.util.ArrayList;
import java.util.List;

public class D26_ValidateStackSequences {
}

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // Pointer to point at the top
        int i = 0;
        int j = 0;

        for (int k = 0 ; k < pushed.length ; k++) {
            int top = pushed[k];
            // point the latest element to the top
            pushed[i] = top;
            while(i >= 0 && pushed[i] == popped[j]) {
                i--;
                j++;
            }
            i++;
        }
        return i == 0;
    }
}

class Solution_2 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        List<Integer> list = new ArrayList<>();
        int c = 0;
        for (int value : popped) {
            boolean check = false;
            if (list.size() > 0 && value == list.get(list.size() - 1)) {
                list.remove(list.size() - 1);
                check = true;
            } else {
                for (int j = c; j < pushed.length; j++) {
                    if (value == pushed[j]) {
                        check = true;
                        c = j + 1;
                        break;
                    } else {
                        list.add(pushed[j]);
                    }
                }
            }
            if (!check) return false;
        }
        return true;
    }
}