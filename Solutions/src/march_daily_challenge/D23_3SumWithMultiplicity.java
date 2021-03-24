package march_daily_challenge;

import java.util.Arrays;

public class D23_3SumWithMultiplicity {
    public static void main(String[] args) {
        ThreeSumWithMultiplicitySolution solution = new ThreeSumWithMultiplicitySolution();
        System.out.println(solution.threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
    }
}

class ThreeSumWithMultiplicitySolution {
    public int threeSumMulti(int[] arr, int target) {
        final int MAX = 100;
        final int MOD = 1_000_000_007;
        final long[] count = new long[101];
        for (int num : arr) {
            count[num]++;
        }

        long result = 0;
        for (int i = 0; i <= MAX; i++) {
            for (int j = i; j <= MAX; j++) {
                int k = target - i - j;

                if (k < j || k > 100) {
                    continue;
                }

                if (count[i] == 0 || count[j] == 0 || count[k] == 0) {
                    continue;
                }

                if (i == j && j == k) {
                    result += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                } else if (i == j && j != k) {
                    result += count[i] * (count[i] - 1) / 2 * count[k];
                } else if (i != j && j == k) {
                    result += count[j] * (count[j] - 1) / 2 * count[i];
                } else {
                    result += count[i] * count[j] * count[k];
                }

                result %= MOD;
            }
        }

        return (int) result;
    }
}

class ThreeSumWithMultiplicitySolution1 {
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1000000007;
        long ans = 0;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; ++i) {
            int T = target - arr[i];
            int j = i + 1, k = arr.length - 1;

            while (j < k) {
                if (arr[j] + arr[k] < T) j++;
                else if (arr[j] + arr[k] > T) k--;
                else if (arr[j] != arr[k]) {
                    int left = 1, right = 1;
                    while (j + 1 < k && arr[j] == arr[j + 1]) {
                        left++;
                        j++;
                    }
                    while (k - 1 > j && arr[k] == arr[k - 1]) {
                        right++;
                        k--;
                    }

                    ans += (long) left * right;
                    ans %= MOD;
                    j++;
                    k--;
                } else {
                    ans += (long) (k - j + 1) * (k - j) / 2;
                    ans %= MOD;
                    break;
                }
            }
        }
        return (int) ans;
    }
}


class ThreeSumWithMultiplicitySolution2 {
    public int threeSumMulti(int[] A, int target) {
        int MOD = 1_000_000_007;
        long ans = 0;
        Arrays.sort(A);

        for (int i = 0; i < A.length; ++i) {
            // We'll try to find the number of i < j < k
            // with A[j] + A[k] == T, where T = target - A[i].

            // The below is a "two sum with multiplicity".
            int T = target - A[i];
            int j = i + 1, k = A.length - 1;

            while (j < k) {
                // These steps proceed as in a typical two-sum.
                if (A[j] + A[k] < T)
                    j++;
                else if (A[j] + A[k] > T)
                    k--;
                else if (A[j] != A[k]) {  // We have A[j] + A[k] == T.
                    // Let's count "left": the number of A[j] == A[j+1] == A[j+2] == ...
                    // And similarly for "right".
                    int left = 1, right = 1;
                    while (j + 1 < k && A[j] == A[j + 1]) {
                        left++;
                        j++;
                    }
                    while (k - 1 > j && A[k] == A[k - 1]) {
                        right++;
                        k--;
                    }

                    ans += left * right;
                    ans %= MOD;
                    j++;
                    k--;
                } else {
                    // M = k - j + 1
                    // We contributed M * (M-1) / 2 pairs.
                    ans += (k - j + 1) * (k - j) / 2;
                    ans %= MOD;
                    break;
                }
            }
        }
        return (int) ans;
    }
}

class ThreeSumWithMultiplicitySolution3 {
    public int threeSumMulti(int[] arr, int target) {
        long[] count = new long[101];
        for (int a : arr)
            count[a]++;
        long result = 0;
//        int n=arr.length;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0)
                    continue;
                if (i == j && j == k)
                    result += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                else if (i == j && j != k)
                    result += count[i] * (count[i] - 1) / 2 * count[k];
                else if (j < k)
                    result += count[i] * count[j] * count[k];
            }
        }
        return (int) (result % (1e9 + 7));
    }
}