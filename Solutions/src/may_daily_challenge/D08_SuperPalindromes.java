package may_daily_challenge;

public class D08_SuperPalindromes {
}

class SuperPalindromesBase3IterationSolution {
    public int superpalindromesInRange(String left, String right) {
        int answer = 9 >= Long.parseLong(left) && 9 <= Long.parseLong(right) ? 1 : 0;
        for (int i = 1; i < 19684; i++) {
            String num = Integer.toString(i, 3);
            if (isPalindrome(num)) {
                long square = Long.parseLong(num) * Long.parseLong(num);
                if (square > Long.parseLong(right)) return answer;
                if (square >= Long.parseLong(left) && isPalindrome(Long.toString(square))) answer++;
            }
        }
        return answer;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}

class SuperPalindromesSolution {
    private long[] all = {0, 1, 4, 9, 121, 484, 10201, 12321, 14641, 40804, 44944, 1002001, 1234321, 4008004, 100020001, 102030201, 104060401, 121242121, 123454321, 125686521, 400080004, 404090404, 10000200001L, 10221412201L, 12102420121L, 12345654321L, 40000800004L, 1000002000001L, 1002003002001L, 1004006004001L, 1020304030201L, 1022325232201L, 1024348434201L, 1210024200121L, 1212225222121L, 1214428244121L, 1232346432321L, 1234567654321L, 4000008000004L, 4004009004004L, 100000020000001L, 100220141022001L, 102012040210201L, 102234363432201L, 121000242000121L, 121242363242121L, 123212464212321L, 123456787654321L, 400000080000004L, 10000000200000001L, 10002000300020001L, 10004000600040001L, 10020210401202001L, 10022212521222001L, 10024214841242001L, 10201020402010201L, 10203040504030201L, 10205060806050201L, 10221432623412201L, 10223454745432201L, 12100002420000121L, 12102202520220121L, 12104402820440121L, 12122232623222121L, 12124434743442121L, 12321024642012321L, 12323244744232321L, 12343456865434321L, 12345678987654321L, 40000000800000004L, 40004000900040004L};

    public int superpalindromesInRange(String left, String right) {
        return countall(Long.valueOf(right)) - countall(Long.valueOf(left) - 1);

    }

    private int countall(long num) {
        int i = 0;
        for (; i < all.length; i++) {
            if (all[i] > num) {
                break;
            }
        }
        return i;
    }
}