package String;

public class ReverseStringII541 {
    public static void main(String[] args) {
        ReverseStringII541 rs = new ReverseStringII541();
        String s = "abcdefg";
        System.out.println(rs.reverseStr(s, 2));
    }
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        int step = 2 * k;
        for (int i = 0; i < s.length(); i += step){
            int m = i, n = Math.min(i + k - 1, s.length() - 1);
            while (m < n){
                char temp = a[m];
                a[m] = a[n];
                a[n] = temp;
                m++;
                n--;
            }
        }
        return new String(a);
    }
}
