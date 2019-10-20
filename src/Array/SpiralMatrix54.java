package Array;
import java.util.*;
/**
 * @author Vincent
 * @Date 10/6/19
 */
public class SpiralMatrix54 {
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, left = 0, right = cols - 1, bottom = rows - 1;
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (res.size() < rows * cols) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++){
                res.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
