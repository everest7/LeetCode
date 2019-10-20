package String;

/**
 * @author Vincent
 * @Date 2019-05-06
 */
public class LongPressedName925 {
    public static void main(String[] args) {
        LongPressedName925 lp = new LongPressedName925();
        System.out.println(lp.isLongPressedName("leelee", "lleeelee"));
    }
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        while (j < typed.length() && typed.charAt(j) == typed.charAt(j - 1)) {j++;}
        return i == name.length() && j == typed.length() ;
    }
}
