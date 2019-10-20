package Greedy;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-22
 */
public class CampusBikes1057 {
    public static void main(String[] args) {

    }

    /**
     * Greedy approach
     * Utilize given range, the maximum distance will not exceed 2001
     * List<int[]>[] is like int[][], but 2D array will have a fixed width, which is not necessary here, we only want
     * dist[i] to be a list of int[] when distance i actual exist.
     * e.g
     * workers = [0,0], [2,1]
     * bikes = [1,2], [2,3]
     *
     * dist[1] = null
     * dist[2] = {[1,0], [1,1]}
     * dist[3] = {[0,0]}
     * dist[4] = {[0,1]}
     *
     * @param workers
     * @param bikes
     * @return
     */
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]>[] bucket = new ArrayList[2001];
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = minDist(workers[i], bikes[j]);
                if (bucket[dist] == null) {
                    bucket[dist] = new ArrayList<int[]>();
                }
                bucket[dist].add(new int[] {i, j});
            }
        }
        boolean[] assigned = new boolean[bikes.length];
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2001; i++) {
            if (bucket[i] == null) continue;
            for (int j = 0; j < bucket[i].size(); j++) {
                int w = bucket[i].get(j)[0];
                int b = bucket[i].get(j)[1];
                if (!assigned[b] && res[w] == -1) {
                    res[w] = b;
                    assigned[b] = true;
                }
            }
        }
        return res;
    }

    public int minDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
