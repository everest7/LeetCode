package TwoPointer;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-15
 */
public class CandyCrush {
    public static void main(String[] args) {
        int[][] board = new int[][] {{10,5,112,113,114},{210,211,5,213,214},{310,311,3,313,314},{410,411,412,5,414},{5,1,512,3,3},{610,4,1,613,614},{710,1,2,713,714},{810,1,2,1,1},{1,1,2,2,2},{4,1,4,4,1014}};
        CandyCrush cc = new CandyCrush();
        System.out.println(Arrays.deepToString(cc.candyCrush(board)));
    }

    public int[][] candyCrush(int[][] board) {
        int rows = board.length, cols = board[0].length;
        while (true) {
            Queue<int[]> crushing = new LinkedList<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0 ; j < cols; j++) {
                    if (board[i][j] == 0) continue;
                    int x0 = i, y0 = j, x1 = i, y1 = j;
                    while (x0 >= 0 && x0 > i - 3 && board[i][j] == board[x0][j]) x0--;
                    while (x1 < rows && x1 < i + 3 && board[i][j] == board[x1][j]) x1++;
                    while (y0 >= 0 && y0 > j - 3 && board[i][j] == board[i][y0]) y0--;
                    while (y1 < cols && y1 < j + 3 && board[i][j] == board[i][y1]) y1++;
                    if (x1 - x0 > 3 || y1 - y0 > 3) crushing.add(new int[] {i, j});
                }
            }
            if (crushing.isEmpty()) break;
            while (!crushing.isEmpty()) {
                int[] tmp = crushing.poll();
                board[tmp[0]][tmp[1]] = 0;
            }
            for (int j = 0; j < cols; j++) {
                int t = rows - 1;
                for (int i = rows - 1; i >= 0; i--) {
                    if (board[i][j] != 0) {
                        swap(board, t, j, i, j);
                        t--;
                    }
                }
            }
        }
        return board;
    }

    public void swap(int[][] board, int i, int j, int x, int y) {
        int tmp =board[i][j];
        board[i][j] = board[x][y];
        board[x][y] = tmp;
    }
}
