package Array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Vincent
 * @Date 9/7/19
 */
public class MakeArrayStrictlyIncreasing {
    public static void main(String[] args) {
//        System.out.println(makeArrayIncreasing(new int[] {1,5,3,6,7}, new int[] {1,3,2,4}));
//        System.out.println(makeArrayIncreasing(new int[] {1,5,3,6,7}, new int[] {4,3,1}));
        System.out.println(makeArrayIncreasing(new int[] {1,5,3,6,7}, new int[] {1,6,3,3}));
    }

    public static int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        Stack<Integer> stack = new Stack<>();
        for (int i = arr2.length - 1; i >= 0; i--) {
            stack.push(arr2[i]);
        }
        int res = 0;
        int idx = 0;
        for (int i = 1; i < arr1.length - 1; i++) {
            if (arr1[i] >= arr1[i + 1] || arr1[i] <= arr1[i - 1]) {
                while (!stack.isEmpty() && (stack.peek() <= arr1[i - 1] || stack.peek() > arr1[i + 1])) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    idx = i;
                    break;
                }

                else {
                    arr1[i] = stack.pop();
                    res++;
                }
            }
        }
//        if (idx < arr1.length && stack.isEmpty()) return -1;
        return res;
    }
}
