package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vincent
 * @Date 2019-07-05
 */
public class ShortestDistancefromBuildings317 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        ShortestDistancefromBuildings317 sd = new ShortestDistancefromBuildings317();
        System.out.println(sd.shortestDistance(grid));
    }

    private int[][] dir = new int[][] {{1,0}, {-1,0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int totalBuilding = 0;
        int[][] dist = new int[rows][cols];
        int[][] cnt = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    totalBuilding++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    boolean[][] visited = new boolean[rows][cols];
                    int level = 1;
                    while (!q.isEmpty()) {
                        int size = q.size();
                        for (int k = 0; k < size; k++) {
                            int[] temp = q.poll();
                            for (int m = 0; m < 4; m++) {
                                int rr = temp[0] + dir[m][0];
                                int cc = temp[1] + dir[m][1];
                                if (rr >= 0 && cc >= 0 && rr < rows && cc < cols && grid[rr][cc] == 0 && !visited[rr][cc]) {
                                    dist[rr][cc] += level;
                                    cnt[rr][cc]++;
                                    q.offer(new int[] {rr, cc});
                                    visited[rr][cc] = true;
                                }
                            }
                        }
                        level++;
                    }

                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cnt[i][j] == totalBuilding && grid[i][j] == 0) {
                    res = Math.min(res, dist[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
