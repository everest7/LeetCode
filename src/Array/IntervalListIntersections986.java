package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vincent
 * @Date 2019-05-12
 */
public class IntervalListIntersections986 {
    public static void main(String[] args) {
        IntervalListIntersections986 il = new IntervalListIntersections986();
        int[][] A = {{0,2},{5,10},{13,23},{24,25}};
        int[][] B = {{1,5},{8,12},{15,24},{25,26}};
        System.out.println(Arrays.deepToString(il.intervalIntersection(A, B)));
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i][1] < B[j][0]) {
                i++;
            }
            else if (A[i][0] > B[j][1]) {
                j++;
            } else {
                addInterval(list, A[i], B[j]);
                if (A[i][1] < B[j][1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;

    }
    public void addInterval(List<int[]> list, int[] A, int[] B) {
        list.add(new int[] {Math.max(A[0], B[0]), Math.min(A[1], B[1])});
    }
}
