import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// ['A', 'A', 'B', 'B', 'C', 'C'] n = 1

// ['A', 'B', 'C', 'A', 'B', 'C'] n = 1
//      <B,1>          4
// A_AB_BC_C
// 'A', _, 'A'

// 1. How long it takes to finish all task.

/*
  A[2], B[2], C[2].
   1     1     1

  A B C  A B C  n = 3 res=1, 2, 3, 4, 5

  <A,3>
  <B,1>
  <C,2>

  i = 3 - 0 = 3
  3 - (3 - 0 - 1) = 1

  4 - 1 <= 3


  A B A  n = 3
  0   2
  A _ A n = 2
  0   1


  A B _ A B n=2 res=1, 2, 3, 4, 5
      res
  <A,1>
  <B,2>

  2 - 2 <= 2
  2 - (2-1) = 1

  4 - 2 + 1 = 3


*/

class Solution {

    public static int taskManager(char[] tasks, int interval) {
        Map<Character, Integer> map = new HashMap<>();
        // <a, 0> - O(1)
        // [A]++  1
        // int[] finish = new int[26];

        int res = 0;
        for (int i = 0; i < tasks.length; i++) {
            if (!map.containsKey(tasks[i])) {
                res++;
            } else {
                if (res - map.get(tasks[i]) + 1<= interval) {  // 1, 'A'(0), 'A' (1)
                    res += interval - (res - map.get(tasks[i]));
                }
                res++;
            }
            map.put(tasks[i], res);
            //finish[tasks[i] - 'A'] = res;
        }
        return res;
    }


    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
    }
}
