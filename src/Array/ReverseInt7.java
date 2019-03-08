package Array;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReverseInt7 {
    public static void main(String[] args) {
        ReverseInt7 rs = new ReverseInt7();
        System.out.println(rs.reverse(123456789));
    }
    public int reverse(int x) {
        long num = x;
        Queue<Integer> queue = new LinkedList<>();
        int counter = 0;
        for (; num != 0; counter++){
            int digit = (int)num % 10;
            queue.add(digit);
            num /= 10;
        }
        long res = 0;
        while (!queue.isEmpty()){
            res += queue.poll() * Math.pow(10,counter - 1);
            counter--;
        }
        if(res > Integer.MAX_VALUE) return 0;
        if(res < Integer.MIN_VALUE) return 0;
        return (int)res;
    }
}
