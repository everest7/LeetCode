package String;

import java.util.Arrays;

/**
 * @author Vincent
 * @Date 2019-05-29
 */
public class ReverseWordsInAStringII186 {
    public static void main(String[] args) {
        char[] str = new char[] {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        ReverseWordsInAStringII186 rw = new ReverseWordsInAStringII186();
        rw.reverseWords(str);
        System.out.println(Arrays.toString(str));
    }

    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
        reverse(str, start, str.length - 1);

    }

    public void reverse(char[] str, int begin, int end) {
        while (begin < end) {
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin++;
            end--;
        }
    }
}
