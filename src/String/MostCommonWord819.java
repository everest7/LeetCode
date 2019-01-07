package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord819 {
    public static void main(String[] args) {
//        String para = "Bob hit a ball, the hit BALL flew far after it was hit." +
//                "how far far far";
        String para2 = "a, a, a, a, b,b,b,c, c";
        String[] banned = {"a"};
        MostCommonWord819 mc = new MostCommonWord819();
        System.out.println(mc.mostCommonWord(para2, banned));
//        String string = para.replaceAll("[^A-Za-z ]", "");
//        String[] words = string.split(" ");
//        for (String st: words){
//            System.out.println(st);
//        }
    }
    public String mostCommonWord(String paragraph, String[] banned) {
        String string = paragraph.replaceAll("[^A-Za-z ]", " ").toLowerCase();
        List<String> list = Arrays.asList(banned);
        Map<String, Integer> map = new HashMap<>();
        String[] words = string.split("\\s+");
        for (String st: words){
            if (!list.contains(st)){
                map.put(st, map.getOrDefault(st, 0) + 1);
            }
        }
        Map.Entry<String, Integer> max = null;
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            if (max == null || entry.getValue().compareTo(max.getValue()) > 0){
                max = entry;
            }
        }
        return max.getKey();


    }
}
