package Array;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-07-03
 */
public class DiagonalTraverse498 {
    public static void main(String[] args) {
        int[][] m = {{ 1, 2, 3 },
                { 4, 5, 6 },
        { 7, 8, 9 }};
        System.out.println(Arrays.toString(findDiagonalOrder(m)));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int x = 0, y = 0, d = 1;
        int[] res = new int[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            res[i] = matrix[x][y];
            x -= d;
            y += d;
            if (x >= rows) {
                x = rows - 1;
                y += 2;
                d = -d;
            }
            if (y >= cols) {
                y = cols - 1;
                x += 2;
                d = -d;
            }
            // out of top border
            if (x < 0) {
                x = 0;
                d = -d;
            }
            if (y < 0) {
                y = 0;
                d = -d;
            }
        }
        return res;
    }

    /**
     * If out of bottom border (row >= m) then row = m - 1; col += 2; change walk direction.
     * Why plus 2?
     * Since every step goes (1, -1) or (-1, 1), when we reach out of the matrix, we are two steps far from its
     * next legal step.
     * if out of right border (col >= n) then col = n - 1; row += 2; change walk direction.
     * if out of top border (row < 0) then row = 0; change walk direction.
     * if out of left border (col < 0) then col = 0; change walk direction.
     * @param matrix
     * @return
     */
//    public int[] findDiagonalOrder(int[][] matrix) {
//        if (matrix.length == 0) return new int[]{};
//        int rows = matrix.length, cols = matrix[0].length;
//        int[] res = new int[rows * cols];
//        int m = 0, n = 0, d = 1;
//        for (int k = 0; k < rows * cols; k++) {
//            res[k] = matrix[m][n];
//            m -= d;
//            n += d;
//            if (m >= rows) {m = rows - 1; n += 2; d = -d;}
//            if (n >= cols) {n = cols - 1; m += 2; d = -d;}
//            if (m < 0) {m = 0; d = -d;}
//            if (n < 0) {n = 0; d = -d;}
//        }
//        return res;
//    }
}
