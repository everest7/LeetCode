package AceInterviewPrep;

import java.util.PriorityQueue;

/**
 * @author Vincent
 * @Date 2019-08-02
 */
public class MatrixGame {
    public static void main(String[] args) {
        int[][] m = new int[][] {
                {3,10,5,3,4,5},
                {4,5,2,6,5,4},
                {7,4,9,7,8,3}
        };
        System.out.println(matrixGame(m));
    }

    public static int matrixGame(int[][] matrix) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int j = 0; j < matrix[0].length; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < matrix.length; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            pq.add(max);
        }
        int sum1 = 0, sum2 = 0;
        while (!pq.isEmpty()) {
            sum1 += pq.poll();
            if (!pq.isEmpty()) sum2 += pq.poll();
        }
        return Math.abs(sum1 - sum2);
    }
}
