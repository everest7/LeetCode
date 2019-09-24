package Backtracking;

public class NQueenProblem {
    public static  int N = 4;
    private static int[][] board = new int[100][100];
    public static void main(String[] args) {
        int i, j;
        for(i=0;i < N;i++)
        NQueen(4);
        {
            for(j=0;j<N;j++)
                System.out.print(board[i][j]+"\t");
            System.out.print("\n");
        }
    }
    public static boolean NQueen(int n){
        int i, j;
        if (n == 0) return true;
        for (i = 0; i < n; i++){
            for (j = 0; j < n; j++){
                if (!isAttack(i, j) || board[i][j] != 1){
                    board[i][j] = 1;
                    if (NQueen(n - 1)){
                        return true;
                    }
                    board[i][j] = 0;
                }
            }
        }
        return false;
    }
    public static boolean isAttack(int m, int n){
        int i, j;
        for (i = 0; i < N; i++){
            if (board[m][i] == 1 || board[i][n] == 1){
                return true;
            }
        }
        for (i = 0; i < N; i++){
            for (j = 0; j < N; j++){
                if (m + n == i + j || m - n == i - j){
                    if (board[i][j] == 1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
