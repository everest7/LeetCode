package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Vincent
 * @Date 2019-07-16
 */
public class TheMazeII505 {
    public static void main(String[] args) {
        int[][] maze = new int[][] {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}};
        TheMazeII505 tm = new TheMazeII505();
        System.out.println(tm.hasPath(maze, new int[]{0,4}, new int[]{4,4}));
    }

    /**
     * Breadth First Search
     */
    int[][] dirs = new int[][] {{1,0}, {-1,0}, {0, 1}, {0, -1}};
    public int hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length, cols = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        q.add(new int[]{start[0], start[1]});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int[] dir : dirs) {
                int nr = tmp[0] + dir[0];
                int nc = tmp[1] + dir[1];
                int step = 0;
                while (nr >= 0 && nc >= 0 && nr < maze.length && nc < maze[0].length && maze[nr][nc] != 1) {
                    nr += dir[0];
                    nc += dir[1];
                    step++;
                }
                nr -= dir[0];
                nc -= dir[1];
                if (dist[tmp[0]][tmp[1]] + step < dist[nr][nc]) {
                    dist[nr][nc] = dist[tmp[0]][tmp[1]] + step;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
    }


    /**
     * DFS
     */
//    int[][] dirs = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
//    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
//        boolean[][] visited = new boolean[maze.length][maze[0].length];
//        int[][] dist = new int[maze.length][maze[0].length];
//        for (int[] row : dist) {
//            Arrays.fill(row, Integer.MAX_VALUE);
//        }
//        int[] res = new int[1];
//        dist[start[0]][start[1]] = 0;
//        dfs(maze, start[0], start[1], dist);
//        return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
//    }
//
//    public void dfs(int[][] maze, int x, int y, int[][] dist) {
//
//        for (int[] dir : dirs) {
//            int nr = x + dir[0];
//            int nc = y + dir[1];
//            int step = 0;
//            while (nr >= 0 && nc >= 0 && nr < maze.length && nc < maze[0].length && maze[nr][nc] != 1) {
//                nr += dir[0];
//                nc += dir[1];
//                step++;
//            }
//            nr -= dir[0];
//            nc -= dir[1];
//            if (dist[x][y] + step < dist[nr][nc]) {
//                dist[nr][nc] = dist[x][y] + step;
//                dfs(maze, nr, nc, dist);
//            }
//        }
//    }
}
