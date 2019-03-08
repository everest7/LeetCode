package Array;

public class RangeAdditionII598 {
    public static void main(String[] args) {
        int[][] ops = {{2,2},{3,3}};
        RangeAdditionII598 ra = new RangeAdditionII598();
        System.out.println(ra.maxCount(3, 3, ops));
    }

    public int maxCount(int m, int n, int[][] ops){
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for(int[] op: ops){
            i = Math.min(i, op[0]);
            j = Math.min(j, op[1]);
        }
        return i * j;
    }

    // Naive approach
//    public int maxCount(int m, int n, int[][] ops) {
//        int[][] nums = new int[m][n];
//        for (int[] op: ops){
//            for (int i = 0; i < op[0]; i++){
//                for (int j = 0; j < op[1]; j++){
//                    nums[i][j]++;
//                }
//            }
//        }
//        int count = 0;
//        for (int i = 0; i < m; i++){
//            for (int j = 0; j < n; j++){
//                if (nums[i][j] == nums[0][0]){
//                    count++;
//                }
//            }
//        }
//        return count;
//
//    }
}
