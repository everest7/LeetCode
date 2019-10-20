package Graph;
import java.util.*;
/**
 * @author Vincent
 * @Date 9/28/19
 */
public class MinimumMovesToReachTargetWithRotation {
    public static void main(String[] args) {
        int[][] m = {{0,0,0,0,0,1},{1,1,0,0,1,0},{0,0,0,0,1,1},{0,0,1,0,1,0},{0,1,1,0,0,0},{0,1,1,0,0,0}};
//        int[][] m = {{0,0,1},{0,0,1}, {0,0,0}};
        int[][] mm = {{0,0,0,0,0,0,0,0,0,1},{0,1,0,0,0,0,0,1,0,1},{1,0,0,1,0,0,1,0,1,0},{0,0,0,1,0,1,0,1,0,0},{0,0,0,0,1,0,0,0,0,1},{0,0,1,0,0,0,0,0,0,0},{1,0,0,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,0}};
        System.out.println(minimumMoves(mm));
    }

    public static int minimumMoves(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0, 0, 1});
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                if (cur[0] == rows - 1 && cur[1] == cols - 2 && cur[2] == rows - 1 && cur[3] == cols - 1) return step;
                // check hori
                if (cur[0] == cur[2]) {
                    //right
                    if (!outRange(cur[2], cur[3], cur[2], cur[3] + 1, rows, cols) && grid[cur[2]][cur[3] + 1] != 1) {
                        if (!outRange(cur[2], cur[3], cur[2], cur[3] + 1, rows, cols)){
                            q.offer(new int[]{cur[2], cur[3], cur[2], cur[3] + 1});
                        }
                    }
                    //bottom
                    if (!outRange(cur[0] + 1, cur[1], cur[2] + 1, cur[3], rows, cols) && grid[cur[0] + 1][cur[1]] != 1 && grid[cur[2] + 1][cur[3]] != 1) {
                        if (!outRange(cur[0] + 1, cur[1], cur[2] + 1, cur[3], rows, cols)){

                            q.offer(new int[]{cur[0] + 1, cur[1], cur[2] + 1, cur[3]});
                        }
                        if (!outRange(cur[0], cur[1], cur[0] + 1, cur[1], rows, cols)){

                            q.offer(new int[]{cur[0], cur[1], cur[0] + 1, cur[1]});
                        }
                    }
                } else { // vertical
                    if (!outRange(cur[2], cur[3], cur[2] + 1, cur[3], rows, cols) && grid[cur[2] + 1][cur[3]] != 1) { // down
                        q.offer(new int[]{cur[2], cur[3], cur[2] + 1, cur[3]});
                    }
                    //bottom
                    if (!outRange(cur[0], cur[1] + 1, cur[2], cur[3] + 1, rows, cols) && grid[cur[0]][cur[1] + 1] != 1 && grid[cur[2]][cur[3] + 1] != 1) {
                        if (!outRange(cur[0], cur[1] + 1, cur[2], cur[3] + 1, rows, cols)) {
                            q.offer(new int[]{cur[0], cur[1] + 1, cur[2], cur[3] + 1});
                        }
                        if (!outRange(cur[0], cur[1], cur[0], cur[1] + 1, rows, cols)) {
                            q.offer(new int[]{cur[0], cur[1], cur[0], cur[1] + 1});
                        }
                    }
                }
            }
            step++;

        }
        return -1;
    }

    public static boolean outRange(int i, int j, int x, int y, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols) return true;
        if (x < 0 || y < 0 || x >= rows || y >= cols) return true;
        return false;
    }
}
