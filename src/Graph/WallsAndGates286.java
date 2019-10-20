package Graph;
import java.util.*;
/**
 * @author Vincent
 * @Date 9/23/19
 */
public class WallsAndGates286 {
    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        wallsAndGates(rooms);
        System.out.println(Arrays.deepToString(rooms));
    }

    public static void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        int rows = rooms.length, cols = rooms[0].length;
        int[][] dirs = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = rooms[cur[0]][cur[1]];
            for (int[] dir: dirs) {
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];
                if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && rooms[nr][nc] != -1 && rooms[nr][nc] > now) {
                    rooms[nr][nc] = Math.min(rooms[nr][nc], now + 1);
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }
}
