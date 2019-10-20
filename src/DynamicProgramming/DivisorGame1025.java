package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-08-29
 */
public class DivisorGame1025 {
    public static void main(String[] args) {
        System.out.println(divisorGame(3));
        System.out.println(divisorGame(2));
    }

    /**
     * dp[i] denotes whether a player can win with given number i if he is the first turn.
     * In order for the first player to win, two conditions must be satisfied
     * 1. Choosing value x must be a divisor of i, i % x == 0
     * 2. The left value (i - x) is not a winning number for next player. dp[i - x] == false
     * @param N
     * @return
     */
    public static boolean divisorGame(int N) {
        boolean[] dp = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            for (int x = 1; x < i; x++) {
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }
}
