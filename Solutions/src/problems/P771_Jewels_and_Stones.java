package problems;

public class P771_Jewels_and_Stones {
    public static void main(String[] args) {

    }
}

class Solution_Jewels_and_Stones {
    public int numJewelsInStones(String jewels, String stones) {
        int jewelCnt = 0;

        for(int i = 0; i < jewels.length(); i++) {
            for(int j = 0; j < stones.length(); j++) {
                if(stones.charAt(j) == jewels.charAt(i)) jewelCnt++;
            }
        }

        return jewelCnt;
    }
}