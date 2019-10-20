package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vincent
 * @Date 2019-06-15
 */
public class ShortestPathInMatrix1091 {
    public static void main(String[] args) {
        int[][] m = new int[][] {{0,0,0},{1,1,0},{1,1,0}};
//        int[][] m = new int[][] {{0,1},{1,0}};
        ShortestPathInMatrix1091 ss = new ShortestPathInMatrix1091();
        System.out.println(ss.shortestPathBinaryMatrix(m));
    }

    int[] rowi = new int[] {1, 0, 0, -1, 1, 1, -1, -1};
    int[] coli = new int[] {0, 1, -1, 0, 1, -1, 1, -1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0][0] = true;
        grid[0][0] = 1;
        int res = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            int rn = num / col, cn = num % col;
            for (int i = 0; i < 8; i++) {
                int nextr = rn + rowi[i], nextc = cn + coli[i];
                if ((nextr >= 0) && (nextc >= 0) && (nextr < row) && (nextc < col) && grid[nextr][nextc] == 0 && !visited[nextr][nextc]) {
                    visited[nextr][nextc] = true;
                    grid[nextr][nextc] = grid[rn][cn] + 1;
//                    res = res + (i < 4 ? 1 : 2);
                    queue.add(nextr * col + nextc);
                }
                if (nextc == col - 1 && nextr == row - 1) return grid[nextr][nextc];
            }
        }
        return -1;
    }
}
