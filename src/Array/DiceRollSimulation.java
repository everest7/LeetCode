package Array;

/**
 * @author Vincent
 * @Date 10/12/19
 */
public class DiceRollSimulation {
    public static void main(String[] args) {
        System.out.println(dieSimulator(2, new int[] {1,1,2,2,2,3}));
        System.out.println(dieSimulator(3, new int[] {1,1,1,2,2,3}));
    }

    public static int dieSimulator(int n, int[] rollMax) {
        int mod = 1000000009;
        long res = 1;
        for (int i = 0; i < n; i++) {
            res = (res * 6) % mod;
        }
        for (int max: rollMax) {
            if (max < n) {
                for (int i = max + 1; i <= n; i++) {
                    int diff = n - i;

                    res -= Math.pow(5,diff) % mod;
                }
//                if (Math.abs(n - max) == 1) res--;
//                else {
//                    int diff = Math.abs(n - max);
//                    res -= ((max + 1) * 2 * Math.pow(5, max)) % mod;
//                }
            }
        }
        return (int)res;
    }
}
