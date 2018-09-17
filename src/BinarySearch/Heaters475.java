package BinarySearch;

import java.util.Arrays;

public class Heaters475 {
    public static void main(String[] args) {
        Heaters475 ht = new Heaters475();
        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};
        System.out.println(ht.findRadius(houses,heaters));
    }
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
    public int findRadius(int[] houses, int[] heaters){
        Arrays.sort(heaters);
        int res = 0;
        for (int house : houses){
            int index = Arrays.binarySearch(heaters,house);
            if (index < 0){
                index = -(index + 1);
                int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
                res = Math.max(res,Math.min(dist1,dist2));
            }
        }
        return res;
    }
}
