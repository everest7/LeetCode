package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings249 {
    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        GroupShiftedStrings249 gs = new GroupShiftedStrings249();
        System.out.println(gs.groupStrings(strings));
    }
    public List<List<String>> groupStrings(String[] strings){
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strings){
            int diff = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++){
                char c = (char) (str.charAt(i) - diff);
                if (c < 'a'){
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)){
                List<String> sub = new ArrayList<>();
                map.put(key, sub);
                res.add(sub);
            }
            map.get(key).add(str);
        }
        return res;
    }

//    public List<List<String>> groupStrings(String[] strings) {
//        List<List<String>> re = new ArrayList<>();
//        Map<String,List<String>> map = new HashMap<>();
//        for (String str : strings){
//            String key = getKey(str);
//            List<String> sub = map.getOrDefault(key, new ArrayList<>());
//            sub.add(str);
//            map.put(key, sub);
//
//        }
//        return new ArrayList<>(map.values());
//    }
//
//    public String getKey(String str){
//        char[] chars = str.toCharArray();
//        String key = "";
//        for (int i = 1; i < chars.length; i++){
//            int diff = chars[i] - chars[i - 1];
//            key += diff < 0 ? diff + 26 : diff;
//            key += ",";
//        }
//        return key;
//    }


}
