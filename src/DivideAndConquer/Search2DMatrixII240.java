package DivideAndConquer;

public class Search2DMatrixII240 {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},
        {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}};
        Search2DMatrixII240 sm = new Search2DMatrixII240();
        System.out.println(sm.searchMatrix(matrix, 5));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        return searchMat(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);

    }
    public boolean searchMat(int[][] matrix, int row1, int col1, int row2, int col2, int target) {
        if (row1 > row2 || col1 > col2) return false;
        if (row1 == row2 && col1 == col2 && matrix[row1][col1] != target) return false;
        if (matrix[row1][col1] > target || matrix[row2][col2] < target) return false;
        int rm = (row1 + row2) / 2;
        int cm = (col1 + col2) / 2;
        if (matrix[rm][cm] == target) {
            return true;
        }
        else if(matrix[rm][cm] > target) {
            return searchMat(matrix, row1, col1, row2, cm - 1, target) ||
                    searchMat(matrix, row1, cm, rm - 1, col2, target);
        } else {
            return searchMat(matrix, row1, cm + 1, row2, col2, target) ||
                    searchMat(matrix, rm + 1, col1, row2, cm, target);
        }
    }

//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix.length == 0) return false;
//        return search(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
//    }
//
//    public boolean search(int[][] M, int row1, int col1, int row2, int col2, int x) {
//        // Base case
//        if (row1 > row2 || col1 > col2) return false;
//        if (row1 == row2 && col1 == col2 && M[row1][col1] != x) return false;
//        if (x < M[row1][col1] || x > M[row2][col2]) return false;
//        int mid = col1 + (col2 - col1) / 2;
//        int row = row1;
//        while (row <= row2 && M[row][mid] <= x) {
//            if (M[row][mid] == x) return true;
//            row++;
//        }
//        return search(M, row, col1, row2,mid - 1,  x) || search(M, row1, mid + 1, row - 1, col2, x);
//    }


//    private int[][] matrix;
//    private int target;
//
//    private boolean searchRec(int left, int up, int right, int down) {
//        // this submatrix has no height or no width.
//        if (left > right || up > down) {
//            return false;
//            // `target` is already larger than the largest element or smaller
//            // than the smallest element in this submatrix.
//        } else if (target < matrix[up][left] || target > matrix[down][right]) {
//            return false;
//        }
//
//        int mid = left + (right-left)/2;
//
//        // Locate `row` such that matrix[row-1][mid] < target < matrix[row][mid]
//        int row = up;
//        while (row <= down && matrix[row][mid] <= target) {
//            if (matrix[row][mid] == target) {
//                return true;
//            }
//            row++;
//        }
//
//        return searchRec(left, row, mid-1, down) || searchRec(mid+1, up, right, row-1);
//    }
//
//    public boolean searchMatrix(int[][] mat, int targ) {
//        // cache input values in object to avoid passing them unnecessarily
//        // to `searchRec`
//        matrix = mat;
//        target = targ;
//
//        // an empty matrix obviously does not contain `target`
//        if (matrix == null || matrix.length == 0) {
//            return false;
//        }
//
//        return searchRec(0, 0, matrix[0].length-1, matrix.length-1);
//    }

    /**
     * ZigZag solution
     * @param matrix
     * @param target
     * @return
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        if (matrix == null || matrix.length == 0) return false;
//        int row = 0, col = matrix[0].length - 1;
//        while (col >= 0 && row < matrix.length){
//            if (matrix[row][col] == target){
//                return true;
//            }
//            else if (matrix[row][col] > target){
//                col--;
//            } else {
//                ++row;
//            }
//        }
//        return false;
//    }
}
