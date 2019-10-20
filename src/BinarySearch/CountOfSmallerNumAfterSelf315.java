package BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent
 * @Date 2019-05-20
 */
public class CountOfSmallerNumAfterSelf315 {
    public static void main(String[] args) {
        CountOfSmallerNumAfterSelf315 cs = new CountOfSmallerNumAfterSelf315();
        System.out.println(cs.countSmaller(new int[] {5, 2, 6, 1}));
    }

    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        List<Integer> res = new ArrayList<>();
        int[] indexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indexes[i] = i;
        }
        mergeSort(nums, indexes, 0, nums.length - 1);
        for (int i = 0; i < count.length; i++) {
            res.add(count[i]);
        }
        return res;
    }

    public void mergeSort(int[] nums, int[] indexes, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(nums, indexes, start, mid);
        mergeSort(nums, indexes, mid + 1, end);
        merge(nums, indexes, start, mid, end);
    }

    public void merge(int[] nums, int[] indexes, int start, int mid, int end) {
        int[] newIndexes = new int[end - start - 1];
        int i = start, j = mid + 1, idx = 0, smallCount = 0;
        while (i <= mid && j <= end) {
            if (nums[indexes[i]] > nums[indexes[j]]) {
                smallCount++;
                newIndexes[idx++] = indexes[j++];
            } else {
                count[indexes[i]] += smallCount;
                newIndexes[idx++] = indexes[i++];
            }
        }
        while (i <= mid) {
            count[indexes[i]] += smallCount;
            newIndexes[idx++] = indexes[i++];
        }
        while (j <= end) {
            newIndexes[idx++] = indexes[j++];
        }

        for (int k = start; k <= end; k++){
            indexes[k] = newIndexes[k - start];
        }

    }

//    int[] count;
//    public List<Integer> countSmaller(int[] nums) {
//        List<Integer> res = new ArrayList<>();
//        count = new int[nums.length];
//        int[] index = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            index[i] = i;
//        }
//        mergeSort(nums, index, 0, nums.length - 1);
//        for (int i = 0; i < count.length; i++) {
//            res.add(count[i]);
//        }
//        return res;
//    }
//    public void mergeSort(int[] nums, int[] index, int begin, int end) {
//        if (begin >= end) {
//            return;
//        }
//        int mid = (begin + end) / 2;
//        mergeSort(nums, index, begin, mid);
//        mergeSort(nums, index, mid + 1, end);
//        merge(nums, index, begin, end);
//    }
//
//    public void merge(int[] nums, int[] index, int begin, int end) {
//        int mid = (begin + end) / 2;
//        int i = begin, j = mid + 1;
//        int numCount = 0, sortIdx = 0;
//        int[] newIndex = new int[end - begin + 1];
//        while (i <= mid && j <= end) {
//            if (nums[index[i]] > nums[index[j]]) {
//                newIndex[sortIdx++] = index[j++];
//            } else {
//                newIndex[sortIdx++] = index[i];
//                count[index[i]] += j - mid;
//                i++;
//            }
//        }
//        while (i <= mid) {
//            count[index[i]] += end - mid;
//            newIndex[sortIdx++] = index[i++];
//        }
//        while (j <= end) {
//            newIndex[sortIdx++] = index[j++];
//        }
//        for (int k = begin; k <= end; k++) {
//            index[k] = newIndex[k - begin];
//        }
//    }
}
