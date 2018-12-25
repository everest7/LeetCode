package DynamicProgramming;

public class PaintFence276 {
    public static void main(String[] args) {
        PaintFence276 pf = new PaintFence276();
        System.out.println(pf.numWays(3, 3));
    }

    /*
    Two cases need to be considered. The continuous two post are same or different.
    For the first two posts:
    Same: for the 1st post, there are k options. For the 2nd post, there are only 1 option.
    Diff: for the 1st post, there are k options, for the 2nd post there are k-1 options.
    From the third post:
    Same: for the third post, there are k-1 options since it cannot be the same as the 1st and 2nd post
    Diff: for the third post, there are k-1 options since it cannot be the same as the 2nd post
    ......
    Different adjacent color option: (same + diff) * (k - 1)
     */
    public int numWays(int n, int k){
        if (n == 0 || k == 0){
            return 0;
        } else if (n == 1){
            return k;
        }
        int same = k;
        int diff = k * (k - 1);
        for (int i = 2; i < n; i++){
            int prevDiff = diff;
            diff = (same + diff) * (k - 1);
            same = prevDiff * 1;
        }
        return same + diff;
    }

//    public int numWays(int n, int k) {
//        if (n == 0 || k == 0){
//            return 0;
//        } else if (n == 1){
//            return k;
//        }
//        int[] f = new int[n + 1];
//        f[0] = 0;
//        f[1] = k;
//        f[2] = k * k;
//        for (int i = 3; i <= n; i++){
//            f[i] = f[i - 1] * (i - 2) + f[i - 2] * (i - 2);
//        }
//        return f[n];
//    }
}
