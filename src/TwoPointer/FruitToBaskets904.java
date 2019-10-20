package TwoPointer;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-07
 */
public class FruitToBaskets904 {
    public static void main(String[] args) {
//        System.out.println(totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
        System.out.println(totalFruit(new int[] {1,2,3,2,2,4,4,4}));
    }

    public static int totalFruit(int[] tree) {
        int res = 0, right = 0, left = 0, cnt = 0;
        int[] map = new int[10];
        while (right < tree.length) {
            if (map[tree[right]]++ == 0) {
                cnt++;

            }
            while (cnt > 2 && left < tree.length) {
                if (--map[tree[left++]] == 0) {
                    cnt--;
                }
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

//    public static int totalFruit(int[] tree) {
//        int[] map = new int[400001];
//        int res = 0, left = 0, cnt = 0;
//        for (int i = 0; i < tree.length; i++) {
//            if (map[tree[i]] == 0) {
//                cnt++;
//            }
//            map[tree[i]]++;
//            while (cnt > 2) {
//                if (--map[tree[left]] == 0) {
//                    cnt--;
//                }
//                left++;
//            }
//            res = Math.max(res, i - left + 1);
//        }
//        return res;
//    }

//    public static int totalFruit(int[] tree) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int res = 0, left = 0;
//        for (int i = 0; i < tree.length; i++) {
//            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
//            while (map.size() > 2) {
//                if (map.get(tree[left]) - 1 == 0) {
//                    map.remove(tree[left]);
//                } else {
//                    map.put(tree[left], map.get(tree[left]) - 1);
//                }
//                left++;
//            }
//            res = Math.max(res, i - left + 1);
//        }
//        return res;
//    }
}
