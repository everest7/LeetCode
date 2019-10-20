package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vincent
 * @Date 2019-05-09
 */
public class FindKClosestElements658 {
    public static void main(String[] args) {
        FindKClosestElements658 fc = new FindKClosestElements658();
        System.out.println(fc.findClosestElements(new int[]{1,2,3,4,5}, 2, 4));
    }

    /**
     * 比较区间两端的数值和x的距离，如果左边离得远了，就向右边走；如果右边离得远了，就像左边走。
     * @param arr
     * @param k
     * @param x
     * @return
     */
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // arr[mid + 1, mid + k] is better than arr[mid, mid + k - 1]
            // increment left counter by 1
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    /**
     * Shrink the window to size of k
     */
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        int[] res = new int[k];
//        int left = 0, right = arr.length - 1;
//        while (left + k < right) {
//            if (Math.abs(arr[right] - x) >= Math.abs(arr[left] - x)) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//        res = Arrays.copyOfRange(arr, left, right);
//        List<Integer> list = Arrays.stream(res).boxed().collect(Collectors.toList());
//        return list;
//    }
}
