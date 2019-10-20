package String;

/**
 * @author Vincent
 * @Date 9/20/19
 */
public class VerifyingAlienDictonary953 {
    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
//        System.out.println(isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        int[] alphbet = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alphbet[order.charAt(i) - 'a'] = i;
        }
        // outer:
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if (!valid(w1, w2, alphbet)) return false;

        }
        return true;
    }

    public static boolean valid(String s1, String s2, int[] alphbet) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return alphbet[s1.charAt(i) - 'a'] < alphbet[s2.charAt(i) - 'a'];
            }
        }
        return s1.length() <= s2.length();
    }

//    public static boolean isAlienSorted(String[] words, String order) {
//        int[] alphbet = new int[26];
//        for (int i = 0; i < order.length(); i++) {
//            alphbet[order.charAt(i) - 'a'] = i;
//        }
//        boolean found = false;
//        for (int i = 0; i < words.length - 1 && !found; i++) {
//            String w1 = words[i];
//            String w2 = words[i + 1];
//            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
//                if (w1.charAt(j) != w2.charAt(j)) {
//                    if (alphbet[w1.charAt(j) - 'a'] > alphbet[w2.charAt(j) - 'a']) {
//                        return false;
//                    }
//                    found = true;
//                    break;
//                }
//            }
//            if (!found && w1.length() > w2.length()) {
//                return false;
//            }
//
//        }
//        return true;
//    }
}
