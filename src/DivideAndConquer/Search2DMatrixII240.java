package DivideAndConquer;

public class Search2DMatrixII240 {
    public static void main(String[] args) {
        int[][] matrix = {{1,   4,  7, 11, 15},
        {2,   5,  8, 12, 19},
        {3,   6,  9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}};
        Search2DMatrixII240 sm = new Search2DMatrixII240();
        System.out.println(sm.searchMatrix(matrix, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int row = 0, col = matrix[0].length - 1;
        while (col >= 0 && row < matrix.length){
            if (matrix[row][col] == target){
                return true;
            }
            else if (matrix[row][col] > target){
                col--;
            } else {
                ++row;
            }
        }
        return false;
    }
}
