package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Vincent
 * @Date 2019-07-16
 */
public class TheMazeIII499 {
    public static void main(String[] args) {

    }

    char[] path = {'d', 'u', 'r', 'l'};
    int[][] dirs = new int[][] {{1,0}, {-1,0}, {0, 1}, {0, -1}};
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int rows = maze.length, cols = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        PriorityQueue<String> pq = new PriorityQueue<>();
        boolean found = false;
        q.add(new int[]{ball[0], ball[1]});
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            for (int i = 0; i < 4 && !found; i++) {
                int nr = tmp[0] + dirs[i][0];
                int nc = tmp[1] + dirs[i][1];
                while (nr >= 0 && nc >= 0 && nr < maze.length && nc < maze[0].length && maze[nr][nc] != 1) {
                    nr += dirs[i][0];
                    nc += dirs[i][1];
                    if (nr == hole[0] && nc == hole[1]) found = true; break;
                }
                nr -= dirs[i][0];
                nc -= dirs[i][1];
            }
        }
        return pq.poll();
    }
}
