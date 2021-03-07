package contests.WeeklyContest231;


public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public static void main(String[] args) {
        System.out.println(CheckIfBinaryStringHasAtMostOneSegmentOfOnesSolution.checkOnesSegment("10"));
    }
}

// Note to self: Solved with brain wrecking pain. Gotta work on basics!
class CheckIfBinaryStringHasAtMostOneSegmentOfOnesSolution {
    public static boolean checkOnesSegment(String s) {
        char[] chars = s.toCharArray();
        if(chars.length == 1 && chars[0] == '1') {
            return true;
        }
        int ones = 0;
        int l = s.length();
        for (char c : chars) {
            if (c == '1') ones++;
        }

        boolean flag = false;
        int count = 0;
        for (int i = 1; i < l; i++) {
            if (chars[i - 1] == '1' && !flag) {
                flag = true;
                count++;
            }
            if (chars[i - 1] == chars[i] && chars[i] == '1') {
                count++;
            } else {
                break;
            }
        }
        return count == ones;
    }
}