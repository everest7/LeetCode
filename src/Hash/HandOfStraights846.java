package Hash;
import java.util.*;
/**
 * @author Vincent
 * @Date 9/15/19
 */
public class HandOfStraights846 {
    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8}, 3));
    }

    public static boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if (n % W != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (!map.isEmpty()) {
            int key = map.firstKey();
            for (int i = 0; i < W; i++) {
                if (!map.containsKey(key + i)) {
                    return false;
                } else {
                    if (map.get(key + i) == 1) {
                        map.remove(key + i);
                    } else {
                        int newVal = map.get(key + i) - 1;
                        if (newVal > 0) {
                            map.put(key + i, newVal);
                        }
                    }
                }

            }
        }
        return true;
    }
}
