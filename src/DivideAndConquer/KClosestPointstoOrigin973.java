package DivideAndConquer;

import java.util.*;
import java.util.Comparator;

public class KClosestPointstoOrigin973 {
    public static void main(String[] args) {
//        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
//        int[][] points = {{6,10}, {-3,3}, {-2,5},{0,2}};
        int[][] points = {{-2,10}, {-4,-8}, {10,7},{-4,-7}};
        KClosestPointstoOrigin973 kc = new KClosestPointstoOrigin973();
        System.out.println(Arrays.deepToString(kc.kClosest(points, 3)));
    }

    public int[][] kClosest(int[][] points, int K) {
        List<int[]> list = new ArrayList<>();
        quickSelect(points, 0, points.length - 1, K, list);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void quickSelect(int[][] points, int left, int right, int k, List<int[]> list) {
        if (left >= right || left >= k || right < k) return;
        int pivot = dist(points[right]);
        int idx = left - 1;
        for (int i = left; i < right; i++) {
            if (dist(points[i]) <= pivot) {
                swap(points, i, idx + 1);
                idx++;
            }
        }
        swap(points, idx + 1, right);
        int count = idx + 1;
        if (count == k) return;
        else if (count > k) {
            quickSelect(points, left, idx - 1, k, list);
        } else {
            quickSelect(points, idx + 1, right, k, list);
        }
    }

    public void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }

    public int dist(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }

    /*
    Using lambda expression to compare
     */
//    public int[][] kClosest(int[][] points, int K){
//        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
//        return Arrays.copyOfRange(points, 0, K);
//    }

    /*
    Sort first, then select the first K elements
     */
//    public int[][] kClosest(int[][] points, int K) {
//        int len = points.length;
//        int[] dis = new int[len];
//        for (int i = 0; i < len; i++){
//            dis[i] = dist(points[i]);
//        }
//        Arrays.sort(dis);
//        int target = dis[K - 1];
//        int[][] res = new int[K][2];
//        int t = 0;
//        for (int i = 0; i < len; i++){
//            if (dist(points[i]) <= target){
//                res[t++] = points[i];
//            }
//        }
//        return res;
//    }
//    public int dist(int[] point){
//        return point[0] * point[0] + point[1] * point[1];
//    }
}
