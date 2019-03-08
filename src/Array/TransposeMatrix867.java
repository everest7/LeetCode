package Array;

import java.util.Arrays;

public class TransposeMatrix867 {
    public static void main(String[] args) {
        TransposeMatrix867 tm = new TransposeMatrix867();
        int[][] A = {{1,2,3},{4,5,6}};
        System.out.println(Arrays.deepToString(tm.transpose(A)));
    }
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] res = new int[col][row];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
