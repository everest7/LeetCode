package Math;

/**
 * @author Vincent
 * @Date 9/10/19
 */
public class ConsecutiveNumbersSum829 {
    public static void main(String[] args) {
        System.out.println(consecutiveNumbersSum(15));
    }

    public static int consecutiveNumbersSum(int N) {
        int res = 0;
        for (int i = 1; ;i++) {
            int ni = N - i * (i - 1) / 2;
            if (ni <= 0) {
                break;
            }
            if (ni % i == 0) {
                res++;
            }
        }
        return res;
    }
}
