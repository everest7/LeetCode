package String;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Vincent
 * @Date 2019-05-23
 */
public class CustomSortString791 {
    public static void main(String[] args) {
        CustomSortString791 ss = new CustomSortString791();
        System.out.println(ss.customSortString("bca", "abcd"));
    }

    public String customSortString(String s, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: T.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                for (int j = 0; j < map.get(s.charAt(i)); j++) {
                    sb.append(s.charAt(i));
                }
                map.put(s.charAt(i), 0);
            }
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) it.next();
            if (entry.getValue() != 0) {
                for (int j = 0; j < entry.getValue(); j++) {
                    sb.append(entry.getKey());
                }
            }
            it.remove();
        }
        return sb.toString();
    }
}
