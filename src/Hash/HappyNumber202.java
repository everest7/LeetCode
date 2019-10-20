package Hash;

import java.util.HashSet;

/**
 * @author Vincent
 * @Date 2019-04-09
 */
public class HappyNumber202 {
    public static void main(String[] args) {
        HappyNumber202 hn = new HappyNumber202();
        System.out.println(hn.isHappy(19));
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n > 0) {
            int sum = 0;
            int num = 0;
            while (n > 0) {
                num = n % 10;
                n /= 10;
                sum += Math.pow(num, 2);
            }
            if (set.contains(sum)) break;
            set.add(sum);
            if (sum == 1) return true;
            n = sum;

        }
        return false;
    }
}
