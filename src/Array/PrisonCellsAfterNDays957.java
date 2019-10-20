package Array;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-08-09
 */
public class PrisonCellsAfterNDays957 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(prisonAfterNDays(new int[] {0,1,0,1,1,0,0,1}, 7)));
//        System.out.println(Arrays.toString(prisonAfterNDays(new int[] {1,0,0,1,0,0,1,0}, 1000000000)));
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < cells.length; j++) {
                if (j == 0 || j == cells.length - 1) {
                    continue;
                }
                if (cells[j] == 1 && (cells[j - 1] & 1) == (cells[j + 1] & 1)) {
                    cells[j] = 3;
                } else if (cells[j] == 0 && (cells[j - 1] & 1) == (cells[j + 1] & 1)){
                    cells[j] = 2;
                }

            }
            for (int j = 0; j < cells.length; j++) {
                cells[j] = cells[j] >> 1;
            }
        }
        return cells;
    }
}
