package String;

import java.util.*;

/**
 * @author Vincent
 * @Date 10/13/19
 */
public class ReorderDatainLogFiles937 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})));
    }

    public static String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String o1, String o2) {
                int idx1 = o1.indexOf(" ");
                int idx2 = o2.indexOf(" ");
                String iden1 = o1.substring(0, idx1), iden2 = o2.substring(0, idx2);
                String log1 = o1.substring(idx1 + 1), log2 = o2.substring(idx2 + 1);
                boolean isDigit1 = Character.isDigit(o1.charAt(idx1 + 1));
                boolean isDigit2 = Character.isDigit(o2.charAt(idx2 + 1));
                if (!isDigit1 && !isDigit2) {
                    if (log1.compareTo(log2) != 0) return log1.compareTo(log2);
                    return iden1.compareTo(iden2);
                }
                return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
            }
        };
        Arrays.sort(logs, comp);
        return logs;
    }
}
