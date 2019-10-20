package Backtracking;

/**
 * @author Vincent
 * @Date 2019-03-08
 */
public class CountNumberswithUniqueDigits3357 {
    public static void main(String[] args) {
        CountNumberswithUniqueDigits3357 cn = new CountNumberswithUniqueDigits3357();
        System.out.println(cn.countNumbersWithUniqueDigits(2));
    }
    public int countNumbersWithUniqueDigits(int n) {
        if (n > 10) return countNumbersWithUniqueDigits(10);
        long max = (long) Math.pow(10, n);
        int res = 1;
        boolean[] visited = new boolean[10];
        for (int i = 1; i < 10; i++) {
            visited[i] = true;
            res += backtrack(i, max, visited);
            visited[i] = false;
        }
        return res;
    }

    public int backtrack(long cur, long max, boolean[] visited) {
        int count = 0;
        if (cur < max) {
            count++;
        } else {
            return count;
        }
        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                long curr = cur * 10 + i;
                count += backtrack(curr, max, visited);
                visited[i] = false;
            }
        }
        return count;
    }
}
