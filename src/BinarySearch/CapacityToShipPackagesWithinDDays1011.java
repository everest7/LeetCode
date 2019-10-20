package BinarySearch;

/**
 * @author Vincent
 * @Date 2019-09-01
 */
public class CapacityToShipPackagesWithinDDays1011 {
    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays1011 ct = new CapacityToShipPackagesWithinDDays1011();
        System.out.println(ct.shipWithinDays(new int[] {1,2,3,1,1}, 4));
    }

    /**
     * The goal is to find the minimum loading capacity X per day so that we can ship all the packages with D days. First,
     * we can find the rough range for X, X must be greater than or equal to the maximum weight of all package, otherwise
     * we would be unable to ship this package. X should be smaller than or equal to the sum weights of all packages,
     * meaning we can ship all the packages in just one day. Therefore we have: max{weights[]} <= X <= sum{weights[]}
     *
     * Using the above range as our binary search interval, calculateDays() will return the number of days needed to
     * ship all the packages with a given loading capacity C. Comparing that with given D days and decide which half
     * interval to go for the next searching interval.
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int days = calculateDays(weights, mid);
            // If number of days needed is greater than given D days, that means our goal cannot be realized, we need to
            // increment the loading capacity, go to the right half interval.
            if (days > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * This function returns number of days needed to ship all the packages with a given loading capacity C.
     */
    public int calculateDays(int[] weights, int capacity) {
        int cnt = 1; // count number of days needed
        int sum = 0;
        for (int w: weights) {
            // If current package plus accumulated weights exceed the capacity limit, that means we need to ship this
            // package in another day.
            if (sum + w > capacity) {
                cnt++;
                sum = w;
            } else { // Capacity limit has not been reached yet, we can ship current package today
                sum += w;
            }
        }
        return cnt;
    }
}
