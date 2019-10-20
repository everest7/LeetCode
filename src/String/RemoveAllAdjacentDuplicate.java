package String;

/**
 * @author Vincent
 * @Date 9/28/19
 */
public class RemoveAllAdjacentDuplicate {
    public static void main(String[] args) {
//        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
//        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
//        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy"
                ,4));
    }

    public static String removeDuplicates(String S, int k) {
        int start = 0;
        StringBuilder input = new StringBuilder(S);
        while (start <= input.length() - k) {
            boolean duplicate = true;
            for (int i = start; i < start + k; i++) {
                if (i > start && input.charAt(i) != input.charAt(i - 1)) {
                    duplicate = false;
                    break;
                }
            }
            if (duplicate) {
                input = input.delete(start, start + k);
                start = 0;
            } else {
                start = start + 1;
            }

        }

        return input.toString();
    }
}
