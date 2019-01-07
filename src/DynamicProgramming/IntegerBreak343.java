package DynamicProgramming;

public class IntegerBreak343 {
    public static void main(String[] args) {
        IntegerBreak343 ib = new IntegerBreak343();
        System.out.println(ib.integerBreak(10));
    }

    public int integerBreak(int n){
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for (int i = 5; i <= n; i++){
            dp[i] = dp[i - 3] * 3;
        }
        return dp[n];
    }

//    public int integerBreak(int n) {
//        if (n <= 3) return n - 1;
//        int res = 1;
//        while (n > 4){
//            res *= 3;
//            n -= 3;
//        }
//        return res * n;
//    }
}
