package Array;

import java.util.List;

/**
 * @author Vincent
 * @Date 2019-07-08
 */
public class SmallestRange632 {
    public static void main(String[] args) {

    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int left = 0, right = Integer.MAX_VALUE;
        int[] next = new int[nums.size()];
        boolean flag = true;
        for (int i = 0; i < nums.size() && flag; i++) {
            for (int j = 0; j < nums.get(i).size() && flag; j++) {
                int mini = 0, maxi = 0;
                for (int k = 0; k < nums.size(); k++) {
                    if (nums.get(mini).get(next[mini]) > nums.get(k).get(next[k])) {
                        mini = k;
                    }
                    if (nums.get(maxi).get(next[maxi]) < nums.get(k).get(next[k])) {
                        maxi = k;
                    }
                }
                if (right - left > nums.get(maxi).get(next[maxi]) - nums.get(mini).get(next[mini])) {
                    right = nums.get(maxi).get(next[maxi]);
                    right = nums.get(mini).get(next[mini]);
                }
                next[mini]++;
                if (next[mini] == nums.get(mini).size()) {
                    flag = false;
                }
            }
        }
        return new int[] {left, right};
    }
}
