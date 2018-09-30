package Hash;

import java.util.*;

public class SortCharFreq451 {
    public static void main(String[] args) {
        SortCharFreq451 sc = new SortCharFreq451();
        String s = "treesssbbbb";
        System.out.println(sc.frequencySort(s));
    }

    // Using Priority Queue
    public String frequencySort(String s){
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        // Lambda expression, serving as a comparator
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()){
            Map.Entry entry = pq.poll();
            for (int i = 0; i < (int)entry.getValue(); i++){
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }

//    public String frequencySort(String s) {
//        StringBuilder sb = new StringBuilder();
//        Map<Character,Integer> map = new HashMap<>();
//        for (char ch : s.toCharArray()){
//            map.put(ch,map.getOrDefault(ch,0) + 1);
//        }
//        List<Character> [] bucket = new List[s.length() + 1];
//        for (char ch : map.keySet()){
//            int frequency = map.get(ch);
//            if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
//            bucket[frequency].add(ch);
//        }
//
//        for (int pos = bucket.length - 1; pos >= 0; pos--){
//            if (bucket[pos] != null){
//                for (char ch : bucket[pos]){
//                    for (int i = 0; i < map.get(ch); i++){
//                        sb.append(ch);
//                    }
//                }
//            }
//        }
//        return sb.toString();
//    }
}
