package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistIII245 {
    /*
    word1 and word2 may be the same and they represent two individual words in the list.
     */
    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        ShortestWordDistIII245 sw = new ShortestWordDistIII245();
        System.out.println(sw.shortestWordDistance(words, "makes", "makes"));
    }

    public int shortestWordDistance(String[] words, String word1, String word2){
        int index1 = -1, index2 = -1;
        int minDist = words.length;
        for (int i = 0; i < words.length; i++){
            if (! word1.equals(word2)){
                if (words[i].equals(word1)){
                    index1 = i;
                } else if (words[i].equals(word2)){
                    index2 = i;
                }
                if (index1 != -1 && index2 != -1){
                    minDist = Math.min(minDist, Math.abs(index1 - index2));
                }
            } else {
                if (words[i].equals(word1)){
                    if (index1 != -1){
                        minDist = Math.min(minDist, Math.abs(i - index1));
                    }
                    index1 = i;
                }
            }
        }
        return minDist;
    }

    // Using HashMap
//    public int shortestWordDistance(String[] words, String word1, String word2) {
//        Map<String, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < words.length; i++){
//            if (map.containsKey(words[i])){
//                map.get(words[i]).add(i);
//            } else {
//                List<Integer> list = new ArrayList<>();
//                list.add(i);
//                map.put(words[i], list);
//            }
//        }
//        int minDist = Integer.MAX_VALUE;
//        List<Integer> list1 = map.get(word1);
//        List<Integer> list2 = map.get(word2);
//        for (int i = 0, j = 0; i < list1.size() && j < list2.size(); ){
//            int index1 = list1.get(i);
//            int index2 = list2.get(j);
//            if (index1 < index2){
//                minDist = Math.min(minDist, index2 - index1);
//                i++;
//            } else if (index1 > index2){
//                minDist = Math.min(minDist, index1 - index2);
//                j++;
//            } else {
//                i++;
//            }
//        }
//        return minDist;
//    }
}
