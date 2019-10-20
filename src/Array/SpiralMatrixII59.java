package Array;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-08-02
 */
public class SpiralMatrixII59 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(2)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        int index = 1;
        while (index <= n * n) {
            for (int j = left; j <= right; j++) {
                result[up][j] = index++;
            }
            up++;
            for (int i = up; i <= down; i++) {
                result[i][right] = index++;
            }
            right--;
            if (up < down) {
                for (int j = right; j >= left; j--) {
                    result[down][j] = index++;
                }
            }
            down--;
            if (left < right) {
                for (int i = down; i >= up; i--) {
                    result[i][left] = index++;
                }
            }
            left++;
        }
        return result;
    }
}
