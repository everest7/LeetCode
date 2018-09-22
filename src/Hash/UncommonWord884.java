package Hash;

import java.util.*;

public class UncommonWord884 {
    public static void main(String[] args) {
        UncommonWord884 uw = new UncommonWord884();
        String a = "this apple is sweet";
        String b = "this apple is sour";
        System.out.println(Arrays.toString(uw.uncommonFromSentences(a,b)));


    }
    // Using HashMap
//    public String[] uncommonFromSentences(String A, String B){
//        String C = A + " " + B;
//        Map<String,Integer> res = new HashMap<>();
//        String[] st = C.split(" ");
//        for (String word : st){
//            res.put(word,res.getOrDefault(word,0) + 1);
//        }
//        List<String> result = new ArrayList<>();
//        for (Map.Entry<String,Integer> entry: res.entrySet()){
//            if (entry.getValue() == 1){
//                result.add(entry.getKey());
//            }
//        }
//        return result.toArray(new String[result.size()]);
//
//    }
    // Using HashSet
    public String[] uncommonFromSentences(String A, String B) {
        String C = A + " " + B;
        String[] st = C.split(" ");
        Set<String> diff = new HashSet<>();
        Set<String> common = new HashSet<>();
        for (String word : st) {
            if (common.contains(word) || !diff.add(word)){
                diff.remove(word);
                common.add(word);
            }
        }

        List<String> res = new ArrayList<>(diff);
        return res.toArray(new String[res.size()]);
    }
}
