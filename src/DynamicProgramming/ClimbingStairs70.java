package DynamicProgramming;

public class ClimbingStairs70 {
    public static void main(String[] args) {
        ClimbingStairs70 cs = new ClimbingStairs70();
        System.out.println(cs.climbStairs(2));
    }
    public int climbStairs(int n){
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i <= n; i++){
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];

    }

    //Brute force
//    public int climbStairs(int n) {
//        return count(0, n);
//    }
//    public int count(int i, int n){
//        if (i > n){
//            return 0;
//        }
//        if (i == n){
//            return 1;
//        }
//        return count(i + 1, n) + count(i + 2, n);
//    }
}
