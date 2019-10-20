package Backtracking;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-08
 */
public class Nqueen51 {
    public static void main(String[] args) {
        Nqueen51 nq = new Nqueen51();
        System.out.println(nq.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] pos = new int[n];
        char[][] chs = new char[n][n];
        for (char[] sub : chs) {
            Arrays.fill(sub, '.');
        }
        backtrack(res, pos, 0, n, chs);
        return res;
    }

    public void backtrack(List<List<String>> res, int[] pos, int cur, int n, char[][] chs) {
        if (cur == n) {
            res.add(construct(chs));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isSafe(pos, cur, j)) {
                chs[cur][j] = 'Q';
                pos[cur] = j;
                backtrack(res, pos, cur + 1, n, chs);
                chs[cur][j] = '.';
                pos[cur] = 0;
            }
        }
    }

    public boolean isSafe(int[] pos, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == pos[i] || Math.abs(row - i) == Math.abs(pos[i] - col)) {
                return false;
            }
        }
        return true;
    }

    public List<String> construct(char[][] chs) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chs.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chs[0].length; j++) {
                sb.append(chs[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }
}
