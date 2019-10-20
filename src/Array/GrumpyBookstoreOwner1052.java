package Array;

/**
 * @author Vincent
 * @Date 2019-05-25
 */
public class GrumpyBookstoreOwner1052 {
    public static void main(String[] args) {
        GrumpyBookstoreOwner1052 gb = new GrumpyBookstoreOwner1052();
        System.out.println(gb.maxSatisfied(new int[] {1,0,1,2,1,1,7,5}, new int[] {0,1,0,1,0,1,0,1}, 3));
//        System.out.println(gb.maxSatisfied(new int[] {1}, new int[] {0}, 1));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        if (customers.length == 0) return 0;
        int res = 0;
        int max = Integer.MIN_VALUE, index = -1;
        int i;
        for (i = 0; i < customers.length - X + 1; i++) {
            int sum = 0;
            for (int j = i; j <= i + X - 1; j++) {
                sum += customers[j];
            }
            if (max < sum) {
                max = sum;
                index = i;
            }
        }
        for (int k = 0; k < customers.length; k++) {
            if (k == index) { k += X;}
            if (k >= customers.length) break;
            res += grumpy[k] == 1 ? 0 : customers[k];
        }
        return res + max;
    }
}
