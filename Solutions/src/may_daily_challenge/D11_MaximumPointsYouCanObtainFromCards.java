package may_daily_challenge;

public class D11_MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        MaximumPointsYouCanObtainFromCardsSolution solution = new MaximumPointsYouCanObtainFromCardsSolution();
        MaximumPointsYouCanObtainFromCardsSolution2 solution2 = new MaximumPointsYouCanObtainFromCardsSolution2();
        System.out.println(solution2.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }
}

class MaximumPointsYouCanObtainFromCardsSolution {
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints.length == 0) return 0;

        int scoreA = 0;
        int scoreB = 0;
        for (int i = 0; i < k; i++) {
            scoreA = scoreA + cardPoints[i];
            scoreB = scoreB + cardPoints[cardPoints.length - (i + 1)];
        }
        return Math.max(scoreA, scoreB);
    }
}

class MaximumPointsYouCanObtainFromCardsSolution2 {
    public int maxScore(int[] cardPoints, int k) {
        if (cardPoints.length == 0) return 0;

        int total = 0;
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }

        int best = total;
        for (int i = k - 1, j = cardPoints.length - 1; i >= 0; i--, j--) {
            total += cardPoints[j] - cardPoints[i];
            best = Math.max(best, total);
        }
        return best;
    }
}

class MaximumPointsYouCanObtainFromCardsSolution3 {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length - k;
        int minSum = Integer.MAX_VALUE;
        int currSum = 0;
        int l = 0;
        int r = 0;
        int total = 0;
        while (r < cardPoints.length) {
            currSum += cardPoints[r];
            total += cardPoints[r];
            if (r - l + 1 == len) {
                minSum = Math.min(minSum, currSum);
                currSum -= cardPoints[l];
                l++;
            }
            r++;
        }
        if (minSum != Integer.MAX_VALUE)
            return total - minSum;
        return total;
    }
}

class MaximumPointsYouCanObtainFromCardsSolution4 {
    public int maxScore(int[] cardPoints, int k) {
        int score = 0;
        for (int i = 0, j = 0; i + j < k; ) {
            if (cardPoints[i] > cardPoints[cardPoints.length - (j + 1)]) {
                score = score + cardPoints[i];
                i++;
            } else {
                score = score + cardPoints[cardPoints.length - (j + 1)];
                j++;
            }
        }
        return score;
    }
}


class MaximumPointsYouCanObtainFromCardsSolution5 {
    public int maxScore(int[] cardPoints, int k) {

        int[] frontSet = new int[k + 1];
        int[] backSet = new int[k + 1];
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            frontSet[i + 1] = cardPoints[i] + frontSet[i];
            backSet[i + 1] = cardPoints[n - 1 - i] + backSet[i];
        }

        int maxScore = 0;
        for (int i = 0; i <= k; i++) {
            maxScore = Math.max(maxScore, frontSet[i] + backSet[k - i]);
        }

        return maxScore;
    }
}

class MaximumPointsYouCanObtainFromCardsSolution6 {
    public int maxScore(int[] A, int k) {
        int total = 0;
        for (int card : A) {
            total += card;
        }

        int window = 0, windowSize = A.length - k;
        for (int i = 0; i < windowSize; i++) {
            window += A[i];
        }

        int minWindow = window;
        for (int l = 0, r = windowSize; r < A.length; l++, r++) {
            window -= A[l];
            window += A[r];
            minWindow = Math.min(minWindow, window);
        }
        return total - minWindow;
    }
}
//    function maxScore(cardPoints,k){
//        let arr = cardPoints;
//        let score=0
//        for (let i = 0; i < k; i++) {
//            if(arr[0]>arr[arr.length-1]) {
//                score=score+arr[0]
//                arr.unshift()
//            }
//            else{
//                score=score+arr[arr.length-1]
//                arr.pop()
//            }
//
//        }
//        return score
//    }
//    function maxScore(arr, k) {
//        let score = 0
//        for (let i = 0; i < k; i++) {
//            if(arr[i]>arr[arr.length-(i+1)]){
//                score= score+arr[i]
//            }
//            else{
//                score= score+arr[arr.length-(i+1)]
//            }
//
//        }
//        return score
//    }

//    function maxScore(arr, k) {
//        let scoreA = 0;
//        let scoreB = 0;
//        for (let i = 0; i < k; i++) {
//
//            scoreA = scoreA + arr[i];
//            scoreB = scoreB + arr[arr.length-(i+1)];
//
//        }
//        if(scoreA > scoreB) {
//            return scoreA
//        }
//        return scoreB
//    }