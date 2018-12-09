package Heap;

import java.util.*;

public class TopKFrequentElements347 {
    public static void main(String[] args) {
        TopKFrequentElements347 tp = new TopKFrequentElements347();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(tp.topKFrequent(nums, 2));
    }

    // Creating a maxHeap to store the entry by its value.
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // lambda expression
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>((a, b) ->(b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }
        while (res.size() < k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

}


