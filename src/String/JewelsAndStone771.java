package String;

import java.util.HashSet;

public class JewelsAndStone771 {
    public static void main(String[] args) {
        JewelsAndStone771 js = new JewelsAndStone771();
        String jewel = "aA";
        String stone = "aaAbbB";
        System.out.println(js.numJewelsInStones(jewel,stone));
    }
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        HashSet setJewel = new HashSet();
        for (int i = 0; i < J.length(); i++){
            setJewel.add(J.charAt(i));
        }
        for(int i = 0; i < S.length(); i++){
            if (setJewel.contains(S.charAt(i))){
                res++;
            }
        }
        return res;

    }
}
