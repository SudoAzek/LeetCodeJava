package problems;

public class P1342_Number_of_Steps_to_Reduce_a_Number_to_Zero {
    public static void main(String[] args) {

    }
}

class Solution_Number_of_Steps_to_Reduce_a_Number_to_Zero {
    public int numberOfSteps(int num) {
        int cnt = 0;
        while(num != 0) {
            if(num % 2 == 1) {
                num -= 1;
            } else {
                num /= 2;
            }
            cnt++;
        }
        return cnt;
    }
}