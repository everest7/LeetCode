package Array;

/**
 * @author Vincent
 * @Date 9/7/19
 */
public class DistanceBetweenBusStops {
    public static void main(String[] args) {
//        System.out.println(distanceBetweenBusStops(new int[]{1,2,3,4}, 0, 1));
//        System.out.println(distanceBetweenBusStops(new int[]{1,2,3,4}, 0, 3));
//        System.out.println(distanceBetweenBusStops(new int[]{1,2,3,4}, 0, 2));
        System.out.println(distanceBetweenBusStops(new int[]{7,10,1,12,11,14,5,0}, 7, 2));
    }

    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int res = 0, ret = 0, n = distance.length;
        for (int i = start; (i % n) != destination; i++) {
            res += distance[i % n];
        }
        for (int i = destination; (i % n)!= start; i++) {
            ret += distance[i % n];
        }
        return Math.min(res, ret);

    }
}
