package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Review May 8
 */
public class KthSmallestElementMatrix378 {
    public static void main(String[] args) {
        int[][] matrix = { {1,  5,  9},
                            {10, 11, 13},
                            {12, 13, 15}};
        KthSmallestElementMatrix378 kl = new KthSmallestElementMatrix378();
        System.out.println(kl.kthSmallest(matrix, 8));
    }

    // Using Binary Search
    public int kthSmallest(int[][] matrix, int k){
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        while (left < right){
            int count = 0;
            int mid = left + (right - left) / 2;
            int j = matrix[0].length - 1; // get the number of column
            for (int i = 0; i < matrix.length; i++){ // iterate each row
                while (j >= 0 && matrix[i][j] > mid){
                    j--;
                }
                count += (j + 1);
            }
            if (count >= k){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Using Priority Queue
    // Time complexity O(n^2)
//    public int kthSmallest(int[][] matrix, int k) {
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        };
//        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);
//        for (int i = 0; i < matrix.length; i++){
//            for (int j = 0; j < matrix[0].length; j++){
//                pq.add(matrix[i][j]);
//            }
//        }
//        while (k > 1){
//            pq.remove();
//            k--;
//        }
//        return pq.remove();
//    }
}
