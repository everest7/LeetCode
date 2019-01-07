package DynamicProgramming;

public class FourKeysKeyboard651 {
    public static void main(String[] args) {
        FourKeysKeyboard651 fk = new FourKeysKeyboard651();
        System.out.println(fk.maxA(13));
    }
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++){
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i - 1; j++){
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1) );
            }
        }
        return dp[N];
    }
}
