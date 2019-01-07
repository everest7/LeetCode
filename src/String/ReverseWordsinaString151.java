package String;

public class ReverseWordsinaString151 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        ReverseWordsinaString151 rw = new ReverseWordsinaString151();
        System.out.println(rw.reverseWords(s));
    }

    public String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        char[] cs = s.toCharArray();
        int index = cs.length - 1;
        while (index >= 0){
            if (cs[index] == ' '){
                index--;
                continue;
            }
            int start = s.lastIndexOf(' ', index) + 1;
            sb.append(' ');
            sb.append(s.substring(start, index + 1));
            index = start - 1;
        }
        if (sb.length() > 0) sb.deleteCharAt(0);
        return sb.toString();
    }

//    public String reverseWords(String s) {
//        String res = "";
//        String[] trans = s.trim().split("\\s+");
//        for (int i = trans.length - 1; i > 0; i--){
//            res = res + trans[i] + " ";
//        }
//        res += trans[0];
//        return res;
//    }
}
