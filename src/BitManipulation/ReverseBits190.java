package BitManipulation;

/**
 * @author Vincent
 * @Date 2019-07-04
 */
public class ReverseBits190 {
    public static void main(String[] args) {

    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                res = (res << 1) + 1;
            } else {
                res = res << 1;
            }
            n = n >> 1;
        }
        return res;
    }
}
