package String;

public class OneEditDistance161 {
    public static void main(String[] args) {
        OneEditDistance161 oed = new OneEditDistance161();
//        System.out.println(oed.isOneEditDistance("ab", "acb"));
        System.out.println(oed.isOneEditDistance("tehr", "te"));
    }

    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0, j = 0; i < s.length()&& j < t.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(j + 1));
                } else if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(j));
                } else {
                    return s.substring(i).equals(t.substring(j + 1));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
//    public boolean isOneEditDistance(String s, String t) {
//        if (t.length() - s.length() > 1) return false;
//        if (t.length() < s.length()) return isOneEditDistance(t, s);
//        int i = 0, j = 0;
//        while (i < s.length() && j < t.length()) {
//            if (s.charAt(i) != t.charAt(j)) {
//                return isOneEditDistance(s.substring(i + 1), t.substring(j + 1))
//                        || isOneEditDistance(s.substring(i), t.substring(j + 1));
//            } else {
//                i++;
//                j++;
//            }
//
//        }
//        return t.length() != s.length();
//    }

//    public boolean isOneEditDistance(String s, String t) {
//        int slen = s.length(), tlen = t.length();
//        if (slen > tlen) {
//            return isOneEditDistance(t, s);
//        }
//        if (tlen - slen > 1) {
//            return false;
//        }
//        for (int i = 0; i < slen; i++) {
//            // two string differ in length by one
//            if (s.charAt(i) != t.charAt(i)) {
//                if (slen == tlen) {
//                    return s.substring(i + 1).equals(t.substring(i + 1));
//                } else {
//                    return s.substring(i).equals(t.substring(i + 1));
//                }
//            }
//        }
//        return slen + 1 == tlen;
//    }
}
