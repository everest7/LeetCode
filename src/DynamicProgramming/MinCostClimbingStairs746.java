package DynamicProgramming;

public class MinCostClimbingStairs746 {
    public static void main(String[] args) {
        MinCostClimbingStairs746 ms = new MinCostClimbingStairs746();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost2 = {10, 15, 20};
        System.out.println(ms.minCostClimbingStairs(cost2));
        System.out.println(ms.minCostClimbingStairs(cost));
    }

    // DP solution:
    /*
    Recurrence: f[i] = cost[i] + min(f[i - 1], f[i - 2])
    In the first loop, it will calculate f[0] and pass it to f[1]
     */
//    public int minCostClimbingStairs(int[] cost) {
//        if (cost == null) return 0;
//        if (cost.length < 2) return cost[0];
//        if (cost.length < 3) return Math.min(cost[0], cost[1]);
//        int f1 = 0, f2 = 0;
//        for (int i = 0; i < cost.length; i++){
//            int f0 = cost[i] + Math.min(f1, f2);
//            f2 = f1;
//            f1 = f0;
//        }
//        return Math.min(f1, f2);
//    }
    public int minCostClimbingStairs(int[] cost){
        int[] f = new int[cost.length + 1];
        f[0] = cost[0];
        f[1] = cost[1];
        for (int i = 2; i <= cost.length; i++){
            if (i == cost.length){
                f[i] = Math.min(f[i - 1], f[i - 2]);
            } else {
                f[i] = Math.min(cost[i] + f[i - 1], cost[i] + f[i - 2]);
            }
        }
        return f[cost.length];
    }
}
