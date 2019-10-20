package Array;

/**
 * @author Vincent
 * @Date 10/19/19
 */
public class FindSlope {
    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0], y1 = coordinates[0][1];
        int x2 = coordinates[1][0], y2 = coordinates[1][1];
        double slope = (y2 - y1) / ((x2 - x1) * 1.0);
        for (int i = 1; i < coordinates.length; i++) {
            double sl = (coordinates[i][1] - y1) / ((coordinates[i][0] - x1) * 1.0);
            if (sl != slope) return false;

        }
        return true;
    }
}
