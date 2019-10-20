package String;

/**
 * @author Vincent
 * @Date 2019-09-02
 */
public class SwapAdjacentLRString777 {
    public static void main(String[] args) {
//        System.out.println(canTransform("RXXLRXRXL", "XRLXXRRLX"));
        System.out.println(canTransform("X", "L"));
    }

    public static boolean canTransform(String start, String end) {
        int i = 0, j = 0;
        char[] ori = start.toCharArray();
        char[] dest = end.toCharArray();
        while (i < ori.length && j < dest.length) {
            while (i < ori.length && ori[i] == 'X') i++;
            while (j < dest.length && dest[j] == 'X') j++;
            if (ori[i] != dest[j]) return false;
            if ((ori[i] == 'L' && i < j) || (ori[i] == 'R' && i > j)) return false;
            i++;
            j++;
        }
        return true;
    }
}
