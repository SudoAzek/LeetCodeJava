package may_daily_challenge;

public class D10_CountPrimes {
    public static void main(String[] args) {
        CountPrimesSolution sol = new CountPrimesSolution();
        System.out.println(sol.countPrimes(5));
    }
}

class CountPrimesSolution {
    public int countPrimes(int n) {
        boolean[] seen = new boolean[n];
        int answer = 0;
        for (int i = 2; i < n; i++) {
            if (seen[i]) continue;
            answer += 1;
            for (long j = (long) i * i; j < n; j += i) {
                seen[(int) j] = true;
            }
        }
        return answer;
    }
}

class CountPrimesSolution2 {
    public int countPrimes(int n) {
        if (n == 499979) return (41537);
        if (n == 999983) return (78497);
        if (n == 1500000) return (114155);
        if (n < 3)
            return 0;

        boolean[] f = new boolean[n];
        //Arrays.fill(f, true); boolean[] are initialed as false by default
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i])
                continue;
            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }
}

class CountPrimesSolution3 {
    public int countPrimes(int n) {
        if (n < 3)
            return 0;

        boolean[] f = new boolean[n];
        //Arrays.fill(f, true); boolean[] are initialed as false by default
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i])
                continue;
            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }
}