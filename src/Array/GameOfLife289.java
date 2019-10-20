package Array;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-01
 */
public class GameOfLife289 {
    public static void main(String[] args) {
        int[][] board = new int[][] {{0,1,1,0},{1,1,0,0}};
        int[] rule = new int[] {0,0,0,3,0,5,0,0,0};
        GameOfLife289 fl = new GameOfLife289();
        for (int j = 0; j < 2; j++) {
            fl.gameOfLife(board, rule);
            for (int[] i: board) {
                System.out.println(Arrays.toString(i));
            }
            System.out.println();
        }
    }

    /**
     * Adjust to see next few round of life status
     * @param board
     * @param rule
     */
    public void gameOfLife(int[][] board, int[] rule) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        Set<Integer> set = new HashSet<>();
        for (int num: rule) {
            if (num != 0) set.add(num);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int ones = 0;
                for (int[] dir: dirs) {
                    int nr = i + dir[0];
                    int nc = j + dir[1];
                    if (nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length) continue;
                    if (board[nr][nc] == 1 || board[nr][nc] == 3 || board[nr][nc] == 2) ones++;
                }
                if (set.contains(ones) && board[i][j] == 1) {
                    board[i][j] = 3;
                } else if (set.contains(ones) && board[i][j] == 0) {
                    board[i][j] = 5;
                } else if (!set.contains(ones) && board[i][j] == 1){
                    board[i][j] = 2;
                } else {
                    board[i][j] = 4;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }

//    public void gameOfLife(int[][] board) {
//        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
//        List<int[]> live = new ArrayList<>();
//        List<int[]> dead = new ArrayList<>();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                int ones = 0, zeros = 0;
//                for (int[] dir: dirs) {
//                    int nr = i + dir[0];
//                    int nc = j + dir[1];
//                    if (nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length) continue;
//                    if (board[nr][nc] == 1) ones++;
//                    if (board[nr][nc] == 0) zeros++;
//                }
//                if (board[i][j] == 1 && (ones < 2 || ones > 3)) dead.add(new int[]{i, j});
//                if (board[i][j] == 0 && ones == 3) live.add(new int[]{i, j});
//            }
//        }
//        for (int[] liv: live) {
//            board[liv[0]][liv[1]] = 1;
//        }
//        for (int[] ded: dead) {
//            board[ded[0]][ded[1]] = 0;
//        }
//    }
}
