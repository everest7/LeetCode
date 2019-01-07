package Heap;

import java.util.*;

public class TopKFrequentWords692 {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        TopKFrequentWords692 tp = new TopKFrequentWords692();
        System.out.println(tp.topKFrequent(words, 2));
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            map.put(words[i],map.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            pq.add(entry);
        }
        while (k > 0){
            res.add(pq.poll().getKey());
            k--;
        }
        return res;
    }
}
