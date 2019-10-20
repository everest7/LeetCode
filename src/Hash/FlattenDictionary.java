package Hash;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-07-26
 */
public class FlattenDictionary {
    public static void main(String[] args) {
        HashMap<String, Object> dict = new HashMap<>();
        Map<String, Object> nest1 = new HashMap<>();
        Map<String, Object> nest2 = new HashMap<>();
        Map<String, Object> nest3 = new HashMap<>();
        nest3.put("","value");
        nest2.put("b", nest3);
        nest1.put("a",nest2);
        dict.put("z",nest1);
        HashMap<String, String> res = flattenDictionary(dict);
        for (Map.Entry<String, String> entry: res.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        // your code goes here
        HashMap<String, String> map = new HashMap<>();
        for (Map.Entry<String, Object> entry: dict.entrySet()) {
            if (entry.getValue() instanceof String) {
                map.put(entry.getKey(), (String) entry.getValue());
            } else {
                HashMap<String, String> nested = flattenDictionary((HashMap<String, Object>)entry.getValue());
                for (Map.Entry<String, String> ent: nested.entrySet()) {
                    if (entry.getKey().length() == 0) {
                        map.put(ent.getKey(), ent.getValue());
                    } else if (ent.getKey().length() == 0) {
                        map.put(entry.getKey(), ent.getValue());
                    } else {
                        map.put(entry.getKey() + "." + ent.getKey(), ent.getValue());
                    }
                }
            }
        }
        return map;
    }

}
