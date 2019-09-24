package BinarySearch;

import java.util.Arrays;

public class Heaters475 {
    public static void main(String[] args) {
        Heaters475 ht = new Heaters475();
        int[] houses = {1, 2, 3, 4};
        int[] heaters = {1, 4};
        System.out.println(ht.findRadius(houses, heaters));
    }

    /**
     * Sort the houses and heaters.
     * Since we need to find heater for every house, therefore, for each house, we can iterate through the heaters
     * and find the nearest one.
     * How to make sure we found the nearest one?
     * After sorting the heaters, we can compare two heaters' distance to house every time
     * if abs(heaters[i + 1] - house) <= abs(heaters[i] - house), that means heater[i + 1] is closer to the house,
     * we increment the counter i by 1.
     *
     * we have |A-X| <= |B-X| && A >= B
     * From the above two condition, we know that (A-X) and (B-X)must be negative,
     * therefore -(A-X) <= -(B-X)  ==> (A-X) >= (B-X)
     * since B-X is negative, X-B must be positive, and (A-X) is negative
     * therefore (X-B) >= (A-X) ==> (A + B) <= 2X
     * @param houses
     * @param heaters
     * @return
     */
//    public int findRadius(int[] houses, int[] heaters) {
//        Arrays.sort(houses);
//        Arrays.sort(heaters);
//        int res = 0, i = 0;
//        for (int house : houses){
//            while (i < heaters.length - 1 && heaters[i] + heaters[i+1] <= house * 2){
//                i++;
//            }
//            res = Math.max(res,Math.abs(heaters[i] - house));
//        }
//        return res;
//    }

    // Using Binary Search

    /**
     * Arrays.binarySearch returns index of the search key, if it is contained in the array; otherwise, (-(insertion point) – 1)
     * Time complexity: O(nlogm) where n is the length of houses, m is the length of heaters.
     *
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        for (int house : houses) {
            int index = Arrays.binarySearch(heaters, house);
            if (index < 0) {
                index = -(index + 1); // find its proper position in heaters.
                int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
                res = Math.max(res, Math.min(dist1, dist2));
            }
        }
        return res;
    }
}
