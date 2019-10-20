package String;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Vincent
 * @Date 2019-05-25
 */
public class LargestNumber179 {
    public static void main(String[] args) {
        LargestNumber179 ln = new LargestNumber179();
        System.out.println(ln.largestNumber(new int[] {2, 10, 20}));
    }

    public String largestNumber(int[] nums) {
        if (nums.length == 0) return "0";
        String[] sts = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sts[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(sts, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String one = o1 + o2;
                String two = o2 + o1;
                return two.compareTo(one);
            }
        });
        if (sts[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String st : sts) {
            sb.append(st);
        }
        return sb.toString();
    }

//    private class LargeComparator implements Comparator<Integer> {
//
//
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            String one = Integer.toString(o1) + Integer.toString(o2);
//            String two = Integer.toString(o2) + Integer.toString(o1);
//            return two.compareTo(one);
//        }
//    }
//
//    public String largestNumber(int[] nums) {
////        Arrays.sort(nums, new LargeComparator());
//        PriorityQueue<Integer> pq = new PriorityQueue<>(new LargeComparator());
//        for (int num : nums) {
//            pq.add(num);
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!pq.isEmpty()) {
//            sb.append(Integer.toString(pq.poll()));
//        }
//        return sb.toString();
//    }
}
