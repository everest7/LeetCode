package Graph;

/**
 * @author Vincent
 * @Date 2019-04-10
 */
public class FriendsCircle547 {
    public static void main(String[] args) {
        int[][] M = {{1,1,0},
                {1,1,0},
                {0,0,1}};
        FriendsCircle547 fc = new FriendsCircle547();
        System.out.println(fc.findCircleNum(M));
    }

    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int res = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    public void dfs(int[][] M, boolean[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }
        }
    }
}
