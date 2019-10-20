package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vincent
 * @Date 2019-07-20
 */
public class PacificAtlanticWaterFlow417 {
    public static void main(String[] args) {
        PacificAtlanticWaterFlow417 pa = new PacificAtlanticWaterFlow417();
        int[][] m = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
//        int[][] m = new int[][]{{1,3},{4,2}};
        System.out.println(pa.pacificAtlantic(m));
    }
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] dp = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dfs(i, j, res, matrix, new boolean[2], dp, new boolean[rows][cols]);
                if (dp[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public void dfs(int i, int j, List<List<Integer>> res, int[][] matrix, boolean[] canFlow, boolean[][] dp, boolean[][] visited) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return;
        }
        if (i == 0 || j == 0) {
            canFlow[0] = true;
        }
        if (i == matrix.length - 1 || j == matrix[0].length - 1) {
            canFlow[1] = true;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr < 0 || nr >= matrix.length || nc < 0 || nc >= matrix[0].length || visited[nr][nc]) continue;
            if (matrix[nr][nc] <= matrix[i][j]) {
                dfs(nr, nc, res, matrix, canFlow, dp, visited);
            }
        }
        dp[i][j] = canFlow[0] && canFlow[1];
    }
}
