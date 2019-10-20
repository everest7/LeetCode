package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vincent
 * @Date 2019-07-16
 */
public class TheMaze490 {
    public static void main(String[] args) {
        int[][] maze = new int[][] {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};
        TheMaze490 tm = new TheMaze490();
        System.out.println(tm.hasPath(maze, new int[] {0,4}, new int[]{3,2}));
    }

    /**
     * Depth First Search
     */

    int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start[0], start[1], destination, visited);
    }

    public boolean dfs(int[][] maze, int x, int y, int[] dest, boolean[][] visited) {
        if (visited[x][y]) return false;
        if (x == dest[0] && y == dest[1]) return true;
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int nr = x + dir[0];
            int nc = y + dir[1];
            while (nr >= 0 && nc >= 0 && nr < maze.length && nc < maze[0].length && maze[nr][nc] != 1) {
                nr += dir[0];
                nc += dir[1];
            }
            nr -= dir[0];
            nc -= dir[1];
            if (dfs(maze, nr, nc, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Breadth First Search
     */
//    int[][] dirs = new int[][] {{1,0}, {-1,0}, {0, 1}, {0, -1}};
//    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//        int rows = maze.length, cols = maze[0].length;
//        Queue<int[]> q = new LinkedList<>();
//        boolean[][] visited = new boolean[rows][cols];
//        q.add(new int[]{start[0], start[1]});
//        visited[start[0]][start[1]] = true;
//        while (!q.isEmpty()) {
//            int[] tmp = q.poll();
//            if (tmp[0] == destination[0] && tmp[1] == destination[1]) return true;
//            for (int[] dir : dirs) {
//                int nr = tmp[0] + dir[0];
//                int nc = tmp[1] + dir[1];
//                while (legalMove(nr, nc, maze)) {
//                    nr += dir[0];
//                    nc += dir[1];
//                }
//                nr -= dir[0];
//                nc -= dir[1];
//                if (!visited[nr][nc]) {
//                    q.add(new int[] {nr, nc});
//                    visited[nr][nc] = true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public boolean legalMove(int i, int j, int[][] maze) {
//        if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length || maze[i][j] == 1) return false;
//        return true;
//    }
}

