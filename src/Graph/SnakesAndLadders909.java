package Graph;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-17
 */
public class SnakesAndLadders909 {
    public static void main(String[] args) {
        int[][] board = new int[][] {{-1,-1,-1,-1,-1,-1},
        {-1,-1,-1,-1,-1,-1},
        {-1,-1,-1,-1,-1,-1},
        {-1,35,-1,-1,13,-1},
        {-1,-1,-1,-1,-1,-1},
        {-1,15,-1,-1,-1,-1}};
    }

    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        int res = 0;
        boolean[] visited = new boolean[n * n + 1];
        Arrays.fill(visited, false);
        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int size = 0;
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == n * n) return res;
                for (int j = 1; j <= 6 && cur + j <= n * n; j++) {
                    int next = getNext(board, cur + j);
                    if (next == -1) next = cur + j;
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
            res++;
        }
        return res;
    }

    public static int getNext(int[][] board, int num) {
        int n = board.length;
        int i = (num - 1) / n, j = (num - 1) % n;
        if (i % 2 == 1) j = n - 1 - j;
        i = n - 1 - i;
        return board[i][j];
    }
}
