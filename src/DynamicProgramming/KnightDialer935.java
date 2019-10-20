package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-07-02
 */
public class KnightDialer935 {
    public static void main(String[] args) {
        KnightDialer935 kd = new KnightDialer935();
        System.out.println(kd.knightDialer(1));
    }

    private int[][] dir = new int[][] {{2,1}, {1,2}, {2, -1}, {1, -2}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};
    public int knightDialer(int N) {
        int[][] dp = new int[4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = 1;
            }
        }
        dp[3][2] = 0;
        dp[3][0] = 0;
        for (int k = 1; k < N; k++) {
            int[][] temp = new int[4][3];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if ((i == 3 && j == 0) || (i == 3 && j == 2)) continue;
                    for (int m = 0; m < 8; m++) {
                        int rr = i + dir[m][0];
                        int cc = j + dir[m][1];
                        if (rr < 0 || rr >= 4 || cc < 0 || cc >= 3) continue;
                        if (rr == 3 && cc == 0) continue;
                        if (rr == 3 && cc == 2) continue;
                        temp[rr][cc] += dp[i][j];
                    }
                }
            }
            dp = temp;
        }
        int res = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                res += dp[i][j];
            }
        }
        return res;
    }
}
