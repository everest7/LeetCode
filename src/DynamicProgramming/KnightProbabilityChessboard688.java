package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-07-02
 */
public class KnightProbabilityChessboard688 {
    public static void main(String[] args) {
        KnightProbabilityChessboard688 kp = new KnightProbabilityChessboard688();
        System.out.println(kp.knightProbability(8,30,6,4));
    }

    private int[][] dir = new int[][] {{2,1}, {1,2}, {2, -1}, {1, -2}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dp = new int[N][N];
        dp[r][c] = 1;
        for (int k = 0; k < K; k++) {
            int[][] temp = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int m = 0; m < 8; m++) {
                        int rr = i + dir[m][0];
                        int cc = j + dir[m][1];
                        if (rr < 0 || cc < 0 || rr >= N || cc >= N) continue;
                        temp[rr][cc] += dp[i][j];
                    }
                }
            }
            dp = temp;
        }
        int total = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                total += dp[i][j];
            }
        }
        return (double) total / Math.pow(8, K);
    }
}
