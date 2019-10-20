package String;

/**
 * @author Vincent
 * @Date 2019-08-01
 */
public class StringCompression443 {
    public static void main(String[] args) {
        StringCompression443 sc = new StringCompression443();
        System.out.println(sc.compress(new char[] {'a','b','b','b','b','b'}));
//        System.out.println(sc.compress(new char[] {'a'}));
    }

    public int compress(char[] chars) {
        int left = 0, right = 0, index = 0;
        for (left = 0, right = 0 ; right < chars.length; left = right) {
            while (right < chars.length && chars[left] == chars[right]) {
                right++;
            }
            chars[index++] = chars[left];
            if (right - left == 1) continue;
            for (char ch : Integer.toString(right - left).toCharArray()) {
                chars[index++] = ch;

            }
        }
        return index;
    }
}
