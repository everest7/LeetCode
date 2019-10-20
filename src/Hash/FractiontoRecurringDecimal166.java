package Hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent
 * @Date 2019-07-04
 */
public class FractiontoRecurringDecimal166 {
    public static void main(String[] args) {
        FractiontoRecurringDecimal166 ff = new FractiontoRecurringDecimal166();
        System.out.println(ff.fractionToDecimal(2, 3));
    }
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        sb.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
        long num = Math.abs((long) numerator);
        long dem = Math.abs((long) denominator);
        sb.append(num / dem);
        long rem = num % dem;
        if (rem == 0) {
            return sb.toString();
        }
        // Factional part
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(rem, sb.length());
        while (rem != 0) {
            rem *= 10;
            sb.append(rem / dem);
            rem %= dem;
            if (map.containsKey(rem)) {
                int index = map.get(rem);
                sb.insert(index, "(");
                sb.append(")");
                break;
            } else {
                map.put(rem, sb.length());
            }
        }
        return sb.toString();
    }
}

