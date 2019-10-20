package Heap;

import java.util.*;

public class TopKFrequentElements347 {
    public static void main(String[] args) {
        TopKFrequentElements347 tp = new TopKFrequentElements347();
        int[] nums = {1,1,1,2,2,3};
        int[] nums2 = {1};
//        System.out.println(tp.topKFrequent(nums, 2));
        System.out.println(tp.topKFrequent(nums2, 1));
    }

    /**
     * Use bucket sort, the frequency of an element cannot exceed the length of input array
     * Time: O(n*maxFreq)
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (int key: freq.keySet()) {
            int count = freq.get(key);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (int j = 0; j < bucket[i].size() && res.size() < k; j++) {
                res.add(bucket[i].get(j));
            }

        }
        return res;
    }

    /**
     * Creating a right to store the entry by its value.
      */
//    public List<Integer> topKFrequent(int[] nums, int k) {
//        List<Integer> res = new ArrayList<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num: nums){
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        // lambda expression
//        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
//                new PriorityQueue<>((a, b) ->(b.getValue() - a.getValue()));
//        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
//            maxHeap.add(entry);
//        }
//        while (res.size() < k){
//            Map.Entry<Integer, Integer> entry = maxHeap.poll();
//            res.add(entry.getKey());
//        }
//        return res;
//    }

}


