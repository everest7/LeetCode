package String;

/**
 * @author Vincent
 * @Date 2019-08-07
 */
public class LicenseKeyFormatting482 {
    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4));
    }

    public static String licenseKeyFormatting(String S, int K) {
        int idx = 0;
        S = S.toUpperCase();
        StringBuilder res = new StringBuilder();
        for(int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '-') continue;
            if (idx != 0 && idx % K == 0) res.append("-");
            res.append(S.charAt(i));
            idx++;
        }
        return res.reverse().toString();

    }

}
