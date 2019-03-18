package DynamicProgramming;

/**
 * @author Vincent
 * @Date 2019-03-09
 */
public class FibonacciNumber509 {
    public static void main(String[] args) {
        FibonacciNumber509 fn = new FibonacciNumber509();
        System.out.println(fn.fib(5));
    }

    public int fib(int N) {
        int[] memo = new int[N + 1];
        return recursion(N, memo);
    }

    public int recursion(int n, int[] memo) {
        if (memo[n] != 0) return memo[n];
        if(n <= 1) {
            memo[n] = n;
            return n;
        } else {
            memo[n] = recursion(n - 1, memo) + recursion(n - 2, memo);
        }
        return memo[n];
    }
}
