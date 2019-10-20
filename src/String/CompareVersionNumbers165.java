package String;

/**
 * @author Vincent
 * @Date 2019-08-03
 */
public class CompareVersionNumbers165 {
    public static void main(String[] args) {
        System.out.println(compareVersion("1", "1.1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] vs1 = version1.split("\\.");
        String[] vs2 = version2.split("\\.");
        int i = 0;
        while (i < Math.min(vs1.length, vs2.length)) {
            Integer v1 = (i >= vs1.length) ? 0 :Integer.parseInt(vs1[i]);
            Integer v2 = (i >= vs2.length) ? 0 :Integer.parseInt(vs2[i]);
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
            i++;
        }
        return 0;
    }
}
