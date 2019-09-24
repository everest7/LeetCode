package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementArray245 {
    public static void main(String[] args) {
        int[] nums = {3,5,6,4};
        KthLargestElementArray245 ks = new KthLargestElementArray245();
        System.out.println(ks.findKthLargest(nums, 2));
    }

    // Using Quick Select
//    public int findKthLargest(int[] nums, int k){
//        int len = nums.length;
//        int index = quickselect(nums, 0, len - 1, len - k + 1);
//        return nums[index];
//    }
//    public int quickselect(int[] nums, int left, int right, int k){
//        int pivot = nums[right];
//        int i = left, j = right;
//        while (i < j){
//            if (nums[i++] > pivot){
//                swap(nums, --i, --j);
//            }
//        }
//        swap(nums, i, right);
//        int num = i - left + 1;
//        if (num == k){
//            return i;
//        } else if (num > k){
//            return quickselect(nums, left, i - 1, k);
//        } else {
//            return quickselect(nums, i + 1, right, k - num);
//        }
//    }
//    public void swap(int[] nums, int i, int j){
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        return quickSelect(nums, k, 0, nums.length - 1);
    }

//    public int quickSelect(int[] nums, int k, int begin, int end) {
//        if (begin >= end) return nums[begin];
//        int index = begin;
//        int pivot = nums[begin];
//        for (int i = begin + 1; i <= end; i++) {
//            if (nums[i] > pivot) {
//                index++;
//                swap(nums, i, index);
//            }
//        }
//        swap(nums, index, begin);
//        if (index + 1 == k) {
//            return nums[index];
//        } else if (index + 1 < k) {
//            return quickSelect(nums, k, index + 1, end);
//        } else {
//            return quickSelect(nums, k, begin, index - 1);
//        }
//    }
    public int quickSelect(int[] nums, int k, int begin, int end) {
        if (begin >= end) return nums[begin];
        int index = begin - 1;
        int pivot = nums[end];
        for (int i = begin; i <= end; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, index + 1);
                index += 1;
            }
        }
        swap(nums, ++index, end);
        if (index + 1 == k) {
            return nums[index];
        } else if (index + 1 < k) {
            return quickSelect(nums, k, index + 1, end);
        } else {
            return quickSelect(nums, k, begin, index - 1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Using Priority Queue
//    public int findKthLargest(int[] nums, int k) {
//        Comparator<Integer> comparator = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        };
//        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);
//        for (int i = 0; i < nums.length; i++){
//            pq.add(nums[i]);
//        }
//        while (k > 1){
//            pq.remove();
//            k--;
//        }
//        return pq.remove();
//    }
}
