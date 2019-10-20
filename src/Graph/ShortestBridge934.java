package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vincent
 * @Date 2019-07-15
 */
public class ShortestBridge934 {
    public static void main(String[] args) {
        ShortestBridge934 sb = new ShortestBridge934();
        System.out.println(sb.shortestBridge(new int[][] {{0,1,0},{0,0,0},{0,0,1}}));
    }

    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] A) {
        int rows = A.length, cols = A[0].length;
        boolean found = false;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 1) {
                    found = true;
                    dfs(A, i, j, visited, q);
                    break;
                }
            }
            if (found) break;
        }
        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i <= size; i++) {
                int[] tmp = q.poll();
                for (int[] next : dir) {
                    int nr = tmp[0] + next[0];
                    int nc = tmp[1] + next[1];
                    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols || visited[nr][nc]) continue;
                    if (A[nr][nc] == 1) {
                        return step;
                    }
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
            step++;
        }
        return -1;
    }

    public void dfs(int[][] A, int i, int j, boolean[][] visited, Queue<int[]> q) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || visited[i][j] || A[i][j] == 0) return;
        visited[i][j] = true;
        // A[i][j] = 2;
        q.add(new int[] {i, j});
        for (int k = 0; k < 4; k++) {
            dfs(A, i + dir[k][0], j + dir[k][1], visited, q);
        }
    }
}
