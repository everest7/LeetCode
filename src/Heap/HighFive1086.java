package Heap;
import java.util.*;
/**
 * @author Vincent
 * @Date 2019-08-01
 */
public class HighFive1086 {
    public static void main(String[] args) {
        int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        HighFive1086 hf = new HighFive1086();
        System.out.println(Arrays.deepToString(hf.highFive(items)));
    }

    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item: items) {
            int id = item[0];
            int score = item[1];
            if (!map.containsKey(id)) {
                map.put(id, new PriorityQueue<>());
            }
            map.get(id).add(score);
            if (map.get(id).size() > 5) {
                map.get(id).poll();
            }
        }
        int[][] res = new int[map.size()][2];
        for (int id: map.keySet()) {
            int sum = 0;
            while (!map.get(id).isEmpty()) {
                sum += map.get(id).poll();
            }
            res[id - 1][0] = id;
            res[id - 1][1] = sum / 5;
        }
        return res;
    }
}
