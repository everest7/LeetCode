package Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DailyTemp739 {
    public static void main(String[] args) {
        DailyTemp739 dt = new DailyTemp739();
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temp2 = {72,72};
        System.out.println(Arrays.toString(dt.dailyTemperatures(temp)));
    }
    // Using Stack
    public int[] dailyTemperatures(int[] temperatures){
        Stack<Integer> stack = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    // Using array
//    public int[] dailyTemperatures(int[] temperatures) {
//        int len = temperatures.length;
//        List<Integer> res = new ArrayList<Integer>();
//        for (int i = 0; i < len -1 ; i++){
//            int days = 0;
//            int j = i + 1;
//            while (j < len){
//                if (temperatures[i] < temperatures[j]) break;
//                j++;
//                days = j - i - 1;
//            }
//            res.add(days);
//        }
//        res.add(0);
//        int[] result = new int[res.size()];
//        for (int i = 0 ; i < result.length; i ++){
//            result[i] = res.get(i);
//        }
//        return result;
//    }
}
