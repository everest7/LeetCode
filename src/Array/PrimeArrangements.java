package Array;

/**
 * @author Vincent
 * @Date 2019-08-31
 */
public class PrimeArrangements {
    public static void main(String[] args) {
//        System.out.println(numPrimeArrangements(5));
//        System.out.println(numPrimeArrangements(2));
//        System.out.println(numPrimeArrangements(10));
        System.out.println(numPrimeArrangements(100));
    }

    public static int numPrimeArrangements(int n) {
        long mod = (long)1e9 + 7;
        int count = countPrimes(n);
        long res = 1;
        for (int i = 1; i <= count; i++) {
            res %= mod;
            res *= i;
        }
        for (int j = 1; j <= n - count; j++) {
            res %= mod;
            res *= j;
        }
        return (int)(res % mod);
    }

    public static int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (!isPrimes[i]) {
                count++;
                for (int j = i; j <= n; j += i) {
                    isPrimes[j] = true;
                }
            }
        }
        return count;
    }
}
