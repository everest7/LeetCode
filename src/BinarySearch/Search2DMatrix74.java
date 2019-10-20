package BinarySearch;

/**
 * @author Vincent
 * @Date 2019-08-17
 */
public class Search2DMatrix74 {
    public static void main(String[] args) {
//        int[][] m = new int[][] {{1,3,4,5}, {10,11,16,20},{23,30,34,50}};
        int[][] m = new int[][] {{1,3,5,7}, {10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix(m, 5));
//        System.out.println(searchMatrix(m, 13));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        return divideConquer(matrix, target, 0, 0, rows - 1, cols - 1);
    }

    public static boolean divideConquer(int[][] m, int t, int x1, int y1, int x2, int y2) {
        if (x1 > x2 || y1 > y2) {
            return false;
        }
        if (x1 == x2 && y1 == y2 && m[x1][y1] != t) return false;
        if (m[x2][y2] < t || m[x1][y1] > t) return false;
        while (x1 <= x2 && y1 <= y2) {
            int x0 = (x1 + x2) / 2;
            int y0 = (y1 + y2) / 2;
            if (m[x0][y0] == t) return true;
            else if (m[x0][y0] < t) {
                return divideConquer(m, t, x1, y0 + 1, x2, y2) || divideConquer(m, t, x0 + 1, y1, x2, y0);
            } else {
                return divideConquer(m, t, x1, y1, x2, y0 - 1) || divideConquer(m, t, x1, y0, x0 - 1, y2);
            }
        }
        return false;
    }
}
