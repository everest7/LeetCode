package Array;

/**
 * @author Vincent
 * @Date 2019-08-02
 */
public class CountPrimes204 {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]) {
                count++;
                for (int j = i; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}
