package contests.BiweeklyContest47;

public class CheckIfNumberIsASumOfPowersOfThree {
    public static void main(String[] args) {
        CheckIfNumberIsASumOfPowersOfThreeSolution sol = new CheckIfNumberIsASumOfPowersOfThreeSolution();
        System.out.println(sol.checkPowersOfThree(12));
    }
}

class CheckIfNumberIsASumOfPowersOfThreeSolution {
    public boolean checkPowersOfThree(int n) {
        if (n < 1) return false;

        for (int i = 0; i < n; i++) {
            
        }

        while (n % 3 == 0) n /= 3;


        return n == 1;
    }
}