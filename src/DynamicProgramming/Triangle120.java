package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle120 {
    public static void main(String[] args) {
        List<Integer> sub1 = Arrays.asList(2);
        List<Integer> sub2 = Arrays.asList(3,4);
        List<Integer> sub3 = Arrays.asList(6,5,7);
        List<Integer> sub4 = Arrays.asList(4,1,8,3);
        List<List<Integer>> list = new ArrayList<>();
        list.add(sub1);
        list.add(sub2);
        list.add(sub3);
        list.add(sub4);
        Triangle120 tl = new Triangle120();
        System.out.println(tl.minimumTotal(list));

    }
//    public int minimumTotal(List<List<Integer>> triangle) {
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(triangle.get(0));
//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i < triangle.size(); i++) {
//            List<Integer> sub = new ArrayList<>();
//            for (int j = 0; j < triangle.get(i).size(); j++) {
//                if (j == 0) {
//                    sub.add(triangle.get(i).get(j) + res.get(i - 1).get(j));
//                } else if (j == triangle.get(i).size() - 1) {
//                    sub.add(triangle.get(i).get(j) + res.get(i - 1).get(j - 1));
//                } else {
//                    sub.add(triangle.get(i).get(j) + Math.min(res.get(i - 1).get(j), res.get(i - 1).get(j - 1)));
//                }
//            }
//            res.add(sub);
//        }
//        for (int num : res.get(triangle.size() - 1)) {
//            if (min > num) {
//                min = num;
//            }
//        }
//        return min;
//    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
