package Array;

import java.util.*;

/**
 * @author Vincent
 * @Date 2019-05-25
 */
public class DistantBarcodes1054 {
    public static void main(String[] args) {
        DistantBarcodes1054 db = new DistantBarcodes1054();
        System.out.println(Arrays.toString(db.rearrangeBarcodes(new int[] {1,1,1,1,2,2,2,2})));
    }
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] res = new int[barcodes.length];
        if (barcodes == null || barcodes.length == 0) return new int[]{};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : barcodes) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq
                = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue() == 0 ? b.getKey() - a.getKey() :
                b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
        }
        int counter = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> first = pq.poll();
            res[counter++] = first.getKey();
            if (!pq.isEmpty()) {
                Map.Entry<Integer, Integer> second = pq.poll();
                res[counter++] = second.getKey();
                if (second.getValue() > 1) {
//                    Map.Entry<Integer, Integer> entry2 = Map.entry(second.getKey(), second.getValue() - 1);
//                    pq.add(entry2);
                    second.setValue(second.getValue() - 1);
                    pq.add(second);
//                    pq.add(Map.entry(second.getKey(), second.getValue() - 1));
                }
            }
            if (first.getValue() > 1) {
                first.setValue(first.getValue() - 1);
                pq.add(first);
//                Map.Entry<Integer, Integer> entry2 = Map.entry(first.getKey(), first.getValue() - 1);
//                pq.add(entry2);
            }
        }
        return res;
    }
}
