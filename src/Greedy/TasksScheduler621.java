package Greedy;
import java.util.*;

/**
 * @author Vincent
 * @Date 2019-07-12
 */
public class TasksScheduler621 {
    public static void main(String[] args) {
        TasksScheduler621 ts = new TasksScheduler621();
        System.out.println(ts.leastInterval(new char[] {'A','A','B','B'},2));
        System.out.println(ts.leastIntervalPrint(new char[] {'A','A','B','B'},2));
    }

    /**
     * Follow up: print the tasks
     */
    public String leastIntervalPrint(char[] tasks, int n) {
        StringBuilder sb = new StringBuilder();
        int[] cnt = new int[26];
        for (char ch : tasks) {
            cnt[ch - 'A']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> (cnt[b - 'A'] - cnt[a - 'A']));
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) pq.add((char)(i + 'A'));
        }
        int res = 0;
        while (!pq.isEmpty()) {
            List<Character> temp = new ArrayList<>();
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty() ) {
                    char cur = pq.poll();
                    sb.append(cur);
                    cnt[cur - 'A']--;
                    if (cnt[cur - 'A'] > 0) {
                        temp.add(cur);
                    }
                    count++;
                }
            }

            for (char ch : temp) {
                pq.add(ch);
            }
            if (pq.isEmpty()) {
                res += count;
            } else {
                res += n + 1;
                if (count != n + 1) {
                    int diff = n + 1 - count;
                    while (diff > 0) {
                        sb.append("_");
                        diff--;
                    }
                }
            }
        }
        return sb.toString();
    }


    /**
     * Greedy approach using PriorityQueue
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char ch : tasks) {
            cnt[ch - 'A']++;
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> (cnt[b - 'A'] - cnt[a - 'A']));
        for (int i = 0; i < 26; i++) {
            if (cnt[i] != 0) pq.add((char)(i + 'A'));
        }
        int res = 0;
        while (!pq.isEmpty()) {
            List<Character> temp = new ArrayList<>();
            int count = 0;
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty() ) {
                    char cur = pq.poll();
                    cnt[cur - 'A']--;
                    if (cnt[cur - 'A'] > 0) {
                        temp.add(cur);
                    }
                    count++;
                }
            }
            for (char ch : temp) {
                pq.add(ch);
            }
            res += pq.isEmpty() ? count : n + 1;
        }
        return res;
    }

    /**
     * Greedy
     * maxFreq: maximum frequency of element in the tasks
     * numMax: number of maximum frequency task
     * tasks: [A, A, A, B, B, B]
     * maxFreq = 3, numMax = 2.
     * A _ _ A _ _ A _ _
     * [          ] => first maxFreq - 1 group = (maxFreq - 1) * (n + 1)
     * In the last group, we just need to insert task that has the same freq as A, => + numMax
     *
     * In the end, we need to compare the result with tasks.length,
     * if length is long enough, you don't have to put idle time.
     * @param tasks
     * @param n
     * @return
     */
//    public int leastInterval(char[] tasks, int n) {
//        int[] nums = new int[26];
//        for (char ch : tasks) {
//            nums[ch - 'A']++;
//        }
//        int maxFreq = 0;
//        int numMax = 1; // frequency of maximum number
//        for (int num : nums) {
//            if (num == 0) continue;
//            if (maxFreq < num) {
//                maxFreq = num;
//                numMax = 1;
//            } else if (maxFreq == num){
//                numMax++;
//            }
//        }
//        int res = (n + 1) * (maxFreq - 1) + numMax;
//        return Math.max(tasks.length, res);
//    }
}
