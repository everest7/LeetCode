package Backtracking;

/**
 * @author Vincent
 * @Date 2019-03-07
 */
public class BeautifulArrangement526 {
    public static void main(String[] args) {
        BeautifulArrangement526 ba = new BeautifulArrangement526();
        System.out.println(ba.countArrangement(5));
    }
    int res = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        backtrack(N, visited, 1);
        return res;
    }

    public void backtrack(int N, boolean[] visited, int pos) {
        if (pos > N) {
            res++;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                backtrack(N, visited, pos + 1);
                visited[i] = false;
            }
        }
    }
}
