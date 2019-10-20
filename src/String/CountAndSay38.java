package String;

/**
 * @author Vincent
 * @Date 2019-05-15
 */
public class CountAndSay38 {
    public static void main(String[] args) {
        CountAndSay38 ca = new CountAndSay38();
        System.out.println(ca.countAndSay(1));
    }

    public String countAndSay(int n) {
        if (n <= 0) return "";
        StringBuilder res = new StringBuilder("1");
        while (n > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.length(); i++) {
                int count = 1;
                while (i + 1< res.length() && res.charAt(i) == res.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb.append(count);
                sb.append(res.charAt(i));
            }
            res = sb;
            n--;
        }
        return res.toString();
    }
}
