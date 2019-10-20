package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent
 * @Date 2019-07-31
 */
public class ConvertNumbertoHexadecimal405 {
    public static void main(String[] args) {
        ConvertNumbertoHexadecimal405 cn = new ConvertNumbertoHexadecimal405();
        System.out.println(cn.toHex(26));
    }

    public String toHex(int num) {
        StringBuilder res = new StringBuilder();
        Map<Integer, Character> map = new HashMap<>();
        map.put(10, 'a');
        map.put(11, 'b');
        map.put(12, 'c');
        map.put(13, 'd');
        map.put(14, 'e');
        map.put(15, 'f');
        int quo = 0, rem = 0;
        while (num > 0) {
            quo = num / 16;
            rem = num % 16;
            if (quo != 0) res.append(quo);
            if (rem < 10 ) {
                res.append(rem);
            } else {
                res.append(map.get(rem));
            }
            num = num / 16;
        }
        return res.toString();
    }
}
