package DynamicProgramming;

/**
 * @author Vincent
 * @Date 9/21/19
 */
public class UnlyNumberIII {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(3,2,3,5));
        System.out.println(nthUglyNumber(4,2,3,4));
        System.out.println(nthUglyNumber(5,2,11,13));
        System.out.println(nthUglyNumber(1000000000,2,217983653,336916467));
    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    static int lcm(int a, int b)
    {
        return (a * b) / gcd(a, b);
    }

    static int divTermCount(int a, int b, int c, int num)
    {

        return ((num / a) + (num / b) + (num / c)
                - (num / lcm(a, b))
                - (num / lcm(b, c))
                - (num / lcm(a, c))
                + (num / lcm(a, lcm(b, c))));
    }

    // Function to find the nth term
    // divisible by a, b or c
    // by using binary search
    public static int nthUglyNumber(int n, int a, int b, int c)
    {

        int low = Math.min(a, Math.min(b, c)), high = Integer.MAX_VALUE, mid;

        while (low < high) {
            mid = low + (high - low) / 2;
            if (divTermCount(a, b, c, mid) < n)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

//    public static int nthUglyNumber(int n, int a, int b, int c) {
//        int res = Math.min(a, Math.min(b, c));
//        int aa = 1, bb = 1, cc = 1;
//        if (res == a) aa++;
//        if (res == b) bb++;
//        if (res == c) cc++;
//        for (int i = 1; i < n; i++) {
//            int aaa = aa * a;
//            int bbb = bb * b;
//            int ccc = cc * c;
//            res = Math.min(aaa, Math.min(bbb, ccc));
//            if (res == aaa) aa++;
//            if (res == bbb) bb++;
//            if (res == ccc) cc++;
//        }
//        return res;
//    }
//    public static int nthUglyNumber(int n, int a, int b, int c) {
//        int[] dp = new int[n];
//        dp[0] = Math.min(a, Math.min(b, c));
//        int aa = 1, bb = 1, cc = 1;
//        if (dp[0] == a) aa++;
//        if (dp[0] == b) bb++;
//        if (dp[0] == c) cc++;
//        for (int i = 1; i < n; i++) {
//            int aaa = aa * a;
//            int bbb = bb * b;
//            int ccc = cc * c;
//            dp[i] = Math.min(aaa, Math.min(bbb, ccc));
//            if (dp[i] == aaa) aa++;
//            if (dp[i] == bbb) bb++;
//            if (dp[i] == ccc) cc++;
//        }
//        return dp[n - 1];
//    }
}
