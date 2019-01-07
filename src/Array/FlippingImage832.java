package Array;

import java.util.Arrays;

public class FlippingImage832 {
    public static void main(String[] args) {
        int[][] input = {{1,1,0},{1,0,1},{0,0,0}};
        FlippingImage832 fp = new FlippingImage832();
        System.out.println(Arrays.deepToString(fp.flipAndInvertImage(input)));
    }

    // Brute force
    public int[][] flipAndInvertImage(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col / 2; j++){
                int temp = A[i][j];
                A[i][j] = A[i][col - j - 1];
                A[i][col - j - 1] = temp;
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (A[i][j] == 0){
                    A[i][j] = 1;
                } else if (A[i][j] == 1){
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }
}
