package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent
 * @Date 2019-07-02
 */
public class NarcissisticNumber {
    public static void main(String[] args) {
        NarcissisticNumber nn = new NarcissisticNumber();
        System.out.println(nn.getNarcissisticNumbers(1));
    }

    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        for (int i = (int)Math.pow(10, n - 1) ; i < (int)Math.pow(10, n); i++) {
            if (narcissistic(i, n)) {
                res.add(i);
            }
        }
        return res;
    }
    public boolean narcissistic(int num, int n) {
        int sum = 0, cur = num;
        while (cur > 0) {
            int rem = cur % 10;
            sum += (int)Math.pow(rem, n);
            cur /= 10;
        }
        return num == sum;
    }
}
