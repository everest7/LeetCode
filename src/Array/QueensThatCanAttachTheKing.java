package Array;
import java.util.*;
/**
 * @author Vincent
 * @Date 10/12/19
 */
public class QueensThatCanAttachTheKing {
    public static void main(String[] args) {
        int[][] queens = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[][] queens2 = {{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}};
        System.out.println(queensAttacktheKing(queens2, new int[]{3,4}));
    }

    public static List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
//        int row = king[0], col = king[1];
//        for (int[] queen: queens) {
//            if (queen[0] == king[0] || queen[1] == king[1] || diag(queen, king)) {
//                res.add(Arrays.asList(queen[0], queen[1]));
//            }
//        }
//        return res;
        int[][] m = new int[8][8];
        for (int[] queen: queens) {
            m[queen[0]][queen[1]] = 1;
        }
        int[][] dirs = new int[][]{{1,0}, {0,-1},{0,1},{-1,0}, {1,1},{1,-1},{-1,1},{-1,-1}};
        for (int[] dir: dirs) {
            dfs(m, king[0], king[1], res,dir[0], dir[1]);
        }
        return res;
    }

    public static void dfs(int[][] m, int row, int col, List<List<Integer>> res, int x, int y) {
        if (row < 0 || col < 0 || row >= m.length || col >= m[0].length) return;
        if (m[row][col] == 1) {
            res.add(Arrays.asList(row, col));
            return;
        }
        dfs(m, row + x, col + y, res, x, y);

    }

    public static boolean diag(int[] queen, int[] king) {
        for (int r = queen[0], c = queen[1]; r < 8 && c < 8; r++, c++) {
            if (r == king[0] && c == king[1]) return true;
        }
        for (int r = queen[0], c = queen[1]; r < 8 && c < 8; r++, c--) {
            if (r == king[0] && c == king[1]) return true;
        }
        for (int r = queen[0], c = queen[1]; r < 8 && c < 8; r--, c++) {
            if (r == king[0] && c == king[1]) return true;
        }
        for (int r = queen[0], c = queen[1]; r < 8 && c < 8; r--, c--) {
            if (r == king[0] && c == king[1]) return true;
        }
        return false;
    }
}
