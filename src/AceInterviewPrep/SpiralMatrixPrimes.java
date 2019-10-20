package AceInterviewPrep;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-08-04
 */
public class SpiralMatrixPrimes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]
                {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}};
        System.out.println(spiralMatrixPrime(matrix));
    }

    public static List<Integer> spiralMatrixPrime(int[][] m) {
        List<Integer> res = new ArrayList<>();
        boolean[] isPrimes = new boolean[1000];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = false;
        isPrimes[1] = false;
        for (int i = 2; i < 1000; i++) {
            if (isPrimes[i]) {
                for (int j = i + i; j < 1000; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        int rows = m.length, cols = m[0].length;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                if (isPrimes[m[top][j]]) {
                    res.add(m[top][j]);
                }
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                if (isPrimes[m[i][right]]) {
                    res.add(m[i][right]);
                }
            }
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    if (isPrimes[m[bottom][j]]) {
                        res.add(m[bottom][j]);
                    }
                }
            }
            bottom--;

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    if (isPrimes[m[i][left]]) {
                        res.add(m[i][left]);
                    }
                }
            }
            left++;
        }
        return res;
    }
}
