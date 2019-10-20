package Array;

/**
 * @author Vincent
 * @Date 2019-07-13
 */
public class LongestWellPerformingInterval1124 {
    public static void main(String[] args) {
        LongestWellPerformingInterval1124 l = new LongestWellPerformingInterval1124();
        System.out.println(l.longestWPI(new int[] {9,9,6,0,6,6,9}));
//        System.out.println(l.longestWPI(new int[] {6,9,9}));
    }

    public int longestWPI(int[] hours) {
        for (int i = 0; i < hours.length; ++i)
            if (hours[i] > 8) hours[i] = 1;
            else hours[i] = -1;

        int ans = 0;
        for (int i = 0; i < hours.length; ++i) {
            int bal = 0, cur = -1;
            for (int j = i; j < hours.length; ++j) {
                bal += hours[j];
                if (bal > 0) cur = j;
            }
            ans = Math.max(ans, cur - i + 1);
        }
        return ans;
    }
}
