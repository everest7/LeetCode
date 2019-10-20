package Array;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-06-22
 */
public class StatLargeSample1093 {
    public static void main(String[] args) {
        int[] count = new int[] {0, 4, 3, 2,2,0, 0};
        StatLargeSample1093 ss = new StatLargeSample1093();

        System.out.println(Arrays.toString(ss.sampleStats(count)));
    }

    public double[] sampleStats(int[] count) {
        double[] res = new double[5];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0, range = 0, most = 0;
        boolean foundMin = false;
        for (int i = 0; i <= 6; i++) {
            if (!foundMin && count[i] != 0) {
                min = i;
                foundMin = true;
            }
            if (count[i] != 0) {
                max = i;
                sum += (count[i] * i);
                range += count[i];
                most = count[i] > most ? i : most;
            }
        }
        int accu = 0;
        double median = 0;
        if (range % 2 != 0) {
            for (int i = 0; i < 7; i++) {
                accu += count[i];
                if (accu == range / 2) {
                    median = i;
                    break;
                }
            }
        } else {
            int i = 0, j = 6;
            int ford = 0, back = 0;
            while (i <= 255) {
                ford += count[i++];
                if (ford > range / 2) {
                    break;
                }

            }
            while (j >= 0) {
                back += count[j--];
                if (back > range / 2) {
                    break;
                }
            }
            median = (i + j ) / 2.0;
        }
        res[0] = (double) min;
        res[1] = (double) max;
        res[2] = (double) sum / range;
        res[3] = median;
        res[4] = (double) most;
        return res;
    }
}
