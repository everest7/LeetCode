package BinarySearch;

/**
 * @author Vincent
 * @Date 2019-09-01
 */
public class MinimizeMaxDistancetoGasStation774 {
    public static void main(String[] args) {
        System.out.println(minmaxGasDist(new int[] {1,2,3,4,5,6,7,8,9,10}, 9));
    }

    public static double minmaxGasDist(int[] stations, int K) {
        double left = 0, right = Math.pow(10, 8);
        while (right - left > Math.pow(10, -6)) {
            double mid = left + (right - left) / 2;
            if (possible(stations, K, mid)) { // current mid distance is possible to realize, can we try better with smaller distance?
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }

    /**
     * This function returns whether it's possible that the distance between two stations is at most D with K stations to add
     * @param stations
     * @param K
     * @param D
     * @return
     */
    public static boolean possible(int[] stations, int K, double D) {
        int cnt = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            cnt += (stations[i + 1] - stations[i]) / D;
        }
        return cnt <= K;
    }
}
