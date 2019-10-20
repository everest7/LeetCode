package Stack;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-25
 */
public class ExclusiveTimeofFunction636 {
    public static void main(String[] args) {
        List<String> logs = Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6");
        System.out.println(Arrays.toString(exclusiveTime(2, logs)));
    }

    /**
     * If it's 'start' log, meaning current second has not been taken.
     * If it's 'end' log, meaning current second has been taken
     * @param n
     * @param logs
     * @return
     */
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        for (String log: logs) {
            String[] s = log.split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += (Integer.parseInt(s[2]) - prev);
                }
                stack.push(Integer.valueOf(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.pop()] += (Integer.parseInt(s[2]) - prev + 1);
                prev = Integer.parseInt(s[2]) + 1;
            }
        }
        return res;
    }
}
